package io.github.peterkaivo.muzmuz.service.impl;

import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundException;
import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundExceptionSupplier;
import io.github.peterkaivo.muzmuz.common.types.MediaType;
import io.github.peterkaivo.muzmuz.repository.AccessoryRepository;
import io.github.peterkaivo.muzmuz.repository.model.DAccessory;
import io.github.peterkaivo.muzmuz.service.*;
import io.github.peterkaivo.muzmuz.service.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class AccessoryServiceImpl implements AccessoryService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccessoryService.class);

    @Autowired
    private AccessoryRepository accessoryRepository;
    @Autowired
    private ImageGalleryService imageGalleryService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private DimensionService dimensionService;
    @Autowired
    private MaterialService materialService;
    
    @Override
    @Transactional(readOnly = true)
    public List<Accessory> getAllAccessories() {
        List<DAccessory> dAccessories = (List<DAccessory>) accessoryRepository.findAll();

        return dAccessories.stream().map(this::fromDAccessory).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Accessory getAccessory(Long id) throws DBObjectNotFoundException {
        DAccessory dAccessory = accessoryRepository.findById(id).orElseThrow(new DBObjectNotFoundExceptionSupplier(DAccessory.class, id));
        return fromDAccessory(dAccessory);
    }

    @Override
    public Accessory saveAccessory(Accessory accessory) {
        accessoryRepository.save(toDAccessory(accessory));
        return accessory;
    }

    @Override
    @Transactional(readOnly = true)
    public Accessory getAccessoryTruncated(Long id) throws DBObjectNotFoundException {
        DAccessory dAccessory = accessoryRepository.findById(id).orElseThrow(new DBObjectNotFoundExceptionSupplier(DAccessory.class, id));
        return fromDAccessoryTruncated(dAccessory);
    }

    @Override
    @Transactional(readOnly = true)
    public Set<Accessory> getAccessoriesTruncated(Set<Long> ids) {
        Set<Accessory> accessories = new HashSet<>();

        for (Long id : ids) {
            try {
                accessories.add(getAccessoryTruncated(id));
            } catch (DBObjectNotFoundException e) {
                LOGGER.warn("getAccessoriesTruncated() - DB inconsistency found for DAccessory with ID = {}", id);
                LOGGER.info(e.getMessage());
            }
        }

        return accessories.isEmpty() ? Collections.emptySet() : accessories;
    }

    private Accessory fromDAccessory(DAccessory dAccessory) {
        Accessory accessory = new Accessory();
        accessory.setId(dAccessory.getId());
        accessory.setInventoryNumber(dAccessory.getInventoryNumber());
        accessory.setName(dAccessory.getName());
        accessory.setAdditionalName(dAccessory.getAdditionalName());

        handleGetGalleries(accessory, dAccessory);

        accessory.setStatus(dAccessory.getStatus());

        try {
            accessory.setLocation(dAccessory.getLocation() == null ? null : locationService.getLocationTruncated(dAccessory.getLocation()));
        } catch (DBObjectNotFoundException e) {
            LOGGER.warn("fromDAccessory() - DB inconsistency found for {} with ID = {}", dAccessory.getClass().getSimpleName(), dAccessory.getId());
            LOGGER.info(e.getMessage());
        }

        accessory.setDimensions(dAccessory.getDimensions() == null ? Collections.emptySet() : dimensionService.getDimensions(dAccessory.getDimensions()));
        accessory.setMaterial(dAccessory.getMaterial() == null ? Collections.emptySet() : materialService.getMaterials(dAccessory.getMaterial()));
        accessory.setDescription(dAccessory.getDescription());
        accessory.setComments(dAccessory.getComments());

        return accessory;
    }

    private void handleGetGalleries(Accessory accessory, DAccessory dAccessory) {
        if (dAccessory.getDefaultGallery() != null) {
            ImageGallery gallery = null;
            try {
                gallery = imageGalleryService.getImageGallery(dAccessory.getDefaultGallery());

                accessory.setDefaultGallery(gallery);
                accessory.setDefaultPhoto(dAccessory.getDefaultPhoto() == null ? null : findDefaultPhoto(gallery, dAccessory));
            } catch (DBObjectNotFoundException e) {
                LOGGER.warn("handleGetGalleries() - DB inconsistency found for DAcquisition with ID = {}: default ImageGallery with ID = {} not found", dAccessory.getId(), dAccessory.getDefaultGallery());
                LOGGER.info(e.getMessage());

                accessory.setDefaultGallery(null);
                accessory.setDefaultPhoto(null);
            }
        } else {
            if (dAccessory.getDefaultPhoto() != null) {
                LOGGER.warn("handleGetGalleries() - DB inconsistency found for DAccessory with ID = {}: default Photo with ID = {} assigned but not present in DefaultGallery",
                        dAccessory.getId(), dAccessory.getDefaultPhoto());
            }

            accessory.setDefaultGallery(null);
            accessory.setDefaultPhoto(null);
        }
    }

    private Photo findDefaultPhoto(ImageGallery gallery, DAccessory dAccessory) {
        for (Graphics graphics : gallery.getImages()) {
            if (graphics.getId().equals(dAccessory.getDefaultPhoto())) {
                if (MediaType.PHOTO.equals(graphics.getType())) {
                    return (Photo) graphics;
                } else {
                    LOGGER.warn("findDefaultPhoto() - DB inconsistency found for {} with ID = {}: default Photo with ID = {} is not Photo but {}", dAccessory.getClass().getSimpleName(), dAccessory.getId(), dAccessory.getDefaultPhoto(), graphics.getType().toString());
                    return null;
                }
            }
        }

        LOGGER.warn("findDefaultPhoto() - DB inconsistency found for {} with ID = {}: default Photo with ID = {} not found in default Gallery {}", dAccessory.getClass().getSimpleName(), dAccessory.getId(), dAccessory.getDefaultPhoto(), gallery.getId());
        return null;
    }

    private Accessory fromDAccessoryTruncated(DAccessory dAccessory) throws DBObjectNotFoundException {
        Accessory accessory = new Accessory();
        accessory.setId(dAccessory.getId());
        accessory.setInventoryNumber(dAccessory.getInventoryNumber());
        accessory.setName(dAccessory.getName());

        handleGetGalleries(accessory, dAccessory);
        accessory.setDefaultGallery(null);

        return accessory;
    }

    private DAccessory toDAccessory(Accessory accessory) {
        DAccessory dAccessory = new DAccessory();
        dAccessory.setId(accessory.getId());
        dAccessory.setInventoryNumber(accessory.getInventoryNumber());
        dAccessory.setName(accessory.getName());
        dAccessory.setAdditionalName(accessory.getAdditionalName());
        dAccessory.setDefaultPhoto(accessory.getDefaultPhoto() == null ? null : accessory.getDefaultPhoto().getId());
        dAccessory.setDefaultGallery(accessory.getDefaultGallery() == null ? null : accessory.getDefaultGallery().getId());
        dAccessory.setStatus(accessory.getStatus());
        dAccessory.setLocation(accessory.getLocation() == null ? null : accessory.getLocation().getId());
        dAccessory.setDimensions(accessory.getDimensions() == null ? null : accessory.getDimensions().stream().map(Dimension::getId).collect(Collectors.toSet()));
        dAccessory.setMaterial(accessory.getMaterial() == null ? null : accessory.getMaterial().stream().map(Material::getId).collect(Collectors.toSet()));
        dAccessory.setDescription(accessory.getDescription());
        dAccessory.setComments(accessory.getComments());
        return dAccessory;
    }
}
