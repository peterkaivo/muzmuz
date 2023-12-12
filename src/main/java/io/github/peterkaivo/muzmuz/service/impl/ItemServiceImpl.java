package io.github.peterkaivo.muzmuz.service.impl;

import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundException;
import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundExceptionSupplier;
import io.github.peterkaivo.muzmuz.common.types.MediaType;
import io.github.peterkaivo.muzmuz.repository.ItemRepository;
import io.github.peterkaivo.muzmuz.repository.model.DItem;
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
public class ItemServiceImpl implements ItemService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemService.class);

    @Autowired
    AccessoryService accessoryService;
    @Autowired
    AudioService audioService;
    @Autowired
    AcquisitionService acquisitionService;
    @Autowired
    ConditionsService conditionsService;
    @Autowired
    DimensionService dimensionService;
    @Autowired
    ExtensionService extensionService;
    @Autowired
    FileService fileService;
    @Autowired
    GraphicsService graphicsService;
    @Autowired
    ImageGalleryService imageGalleryService;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    LinkService linkService;
    @Autowired
    LocationService locationService;
    @Autowired
    MaterialService materialService;
    @Autowired
    SubjectService subjectService;
    @Autowired
    VideoService videoService;

    @Override
    @Transactional(readOnly = true)
    public List<Item> getAllItems() {
        List<DItem> items = (List<DItem>) itemRepository.findAll();

        return items.stream().map(this::fromDItem).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Item getItem(Long id) throws DBObjectNotFoundException {
        DItem item = itemRepository.findById(id).orElseThrow(new DBObjectNotFoundExceptionSupplier(DItem.class, id));

        return fromDItem(item);
    }

    @Override
    public Item saveItem(Item item) {
        itemRepository.save(toDItem(item));

        return item;
    }

    @Override
    @Transactional(readOnly = true)
    public Item getItemTruncated(Long id) throws DBObjectNotFoundException {
        DItem item = itemRepository.findById(id).orElseThrow(new DBObjectNotFoundExceptionSupplier(DItem.class, id));

        return fromDItemTruncated(item);
    }

    @Override
    @Transactional(readOnly = true)
    public Set<Item> getItemsTruncated(Set<Long> ids) {
        Set<Item> items = new HashSet<>();

        for (Long id : ids) {
            try {
                items.add(getItemTruncated(id));
            } catch (DBObjectNotFoundException e) {
                LOGGER.warn("getItemsTruncated() - DB inconsistency found for DItem with ID = {}", id);
                LOGGER.info(e.getMessage());
            }
        }

        return items.isEmpty() ? Collections.emptySet() : items;
    }

    private Item fromDItem(DItem dItem) {
        Item item = new Item();
        item.setId(dItem.getId());
        item.setInventoryNumber(dItem.getInventoryNumber());
        item.setName(dItem.getName());
        item.setAdditionalName(dItem.getAdditionalName());
        item.setCategory(dItem.getCategory());

        handleGetGalleries(item, dItem);

        item.setStatus(dItem.getStatus());
        item.setDescription(dItem.getDescription());
        item.setLabels(dItem.getLabels());
        item.setDrawings(dItem.getDrawings() == null ? null : getDrawings(dItem));
        item.setDimensions(dItem.getDimensions() == null ? null : dimensionService.getDimensions(dItem.getDimensions()));
        item.setMaterial(dItem.getMaterial() == null ? null : materialService.getMaterials(dItem.getMaterial()));

        try {
            item.setLocation(dItem.getLocation() == null ? null : locationService.getLocationTruncated(dItem.getLocation()));
        } catch (DBObjectNotFoundException e) {
            LOGGER.warn("fromDItem() - DB inconsistency found for {} with ID = {}", dItem.getClass().getSimpleName(), dItem.getId());
            LOGGER.info(e.getMessage());
        }

        try {
            item.setOwner(dItem.getOwner() == null ? null : subjectService.getSubjectTruncated(dItem.getOwner()));
        } catch (DBObjectNotFoundException e) {
            LOGGER.warn("fromDItem() - DB inconsistency found for {} with ID = {}", dItem.getClass().getSimpleName(), dItem.getId());
            LOGGER.info(e.getMessage());
        }

        try {
            item.setCurrentConditions(dItem.getCurrentConditions() == null ? null : conditionsService.getConditions(dItem.getCurrentConditions()));
        } catch (DBObjectNotFoundException e) {
            LOGGER.warn("fromDItem() - DB inconsistency found for {} with ID = {}", dItem.getClass().getSimpleName(), dItem.getId());
            LOGGER.info(e.getMessage());
        }

        item.setComments(dItem.getComments());
        item.setManufactureDate(dItem.getManufactureDate());
        item.setManufacturers(dItem.getManufacturers() == null ? null : subjectService.getSubjectsTruncated(dItem.getManufacturers()));

        try {
            item.setAcquisition(dItem.getAcquisition() == null ? null : acquisitionService.getAcquisitionTruncated(dItem.getAcquisition()));
        } catch (DBObjectNotFoundException e) {
            LOGGER.warn("fromDItem() - DB inconsistency found for {} with ID = {}", dItem.getClass().getSimpleName(), dItem.getId());
            LOGGER.info(e.getMessage());
        }

        try {
            item.setAcquisitionCondition(dItem.getAcquisitionCondition() == null ? null : conditionsService.getConditions(dItem.getAcquisitionCondition()));
        } catch (DBObjectNotFoundException e) {
            LOGGER.warn("fromDItem() - DB inconsistency found for {} with ID = {}", dItem.getClass().getSimpleName(), dItem.getId());
            LOGGER.info(e.getMessage());
        }

        item.setAudio(dItem.getAudio() == null ? null : audioService.getAudioSet(dItem.getAudio()));
        item.setVideo(dItem.getVideo() == null ? null : videoService.getVideoSet(dItem.getVideo()));
        item.setFiles(dItem.getFiles() == null ? null : fileService.getFileSet(dItem.getFiles()));
        item.setLinks(dItem.getLinks() == null ? null : linkService.getLinkSet(dItem.getLinks()));
        item.setExtensions(dItem.getExtensions() == null ? null : extensionService.getExtensions(dItem.getExtensions()));
        item.setAccessories(dItem.getAccessories() == null ? null : accessoryService.getAccessoriesTruncated(dItem.getAccessories()));

        return item;
    }

    private Item fromDItemTruncated(DItem dItem) {
        Item item = new Item();
        item.setId(dItem.getId());
        item.setInventoryNumber(dItem.getInventoryNumber());
        item.setName(dItem.getName());
        item.setCategory(dItem.getCategory());

        handleGetGalleries(item, dItem);
        item.setDefaultGallery(null);
        item.setGalleries(null);

        item.setStatus(dItem.getStatus());

        return item;
    }

    private void handleGetGalleries(Item item, DItem dItem) {
        if (dItem.getDefaultGallery() != null) {
            ImageGallery gallery = null;
            try {
                gallery = imageGalleryService.getImageGallery(dItem.getDefaultGallery());

                item.setDefaultGallery(gallery);
                item.setDefaultPhoto(dItem.getDefaultPhoto() == null ? null : findDefaultPhoto(gallery, dItem));
            } catch (DBObjectNotFoundException e) {
                LOGGER.warn("handleGetGalleries() - DB inconsistency found for DItem with ID = {}: default ImageGallery with ID = {} not found", dItem.getId(), dItem.getDefaultGallery());
                LOGGER.info(e.getMessage());

                item.setDefaultGallery(null);
                item.setDefaultPhoto(null);
            }
        } else {
            if (dItem.getDefaultPhoto() != null) {
                LOGGER.warn("handleGetGalleries() - DB inconsistency found for DItem with ID = {}: default Photo with ID = {} assigned but not present in DefaultGallery",
                        dItem.getId(), dItem.getDefaultPhoto());
            }

            item.setDefaultGallery(null);
            item.setDefaultPhoto(null);
        }
    }

    private Photo findDefaultPhoto(ImageGallery gallery, DItem dItem) {
        for (Graphics graphics : gallery.getImages()) {
            if (graphics.getId().equals(dItem.getDefaultPhoto())) {
                if (MediaType.PHOTO.equals(graphics.getType())) {
                    return (Photo) graphics;
                } else {
                    LOGGER.warn("findDefaultPhoto() - DB inconsistency found for {} with ID = {}: default Photo with ID = {} is not Photo but {}", dItem.getClass().getSimpleName(), dItem.getId(), dItem.getDefaultPhoto(), graphics.getType().toString());
                    return null;
                }
            }
        }

        LOGGER.warn("findDefaultPhoto() - DB inconsistency found for {} with ID = {}: default Photo with ID = {} not found in default Gallery {}", dItem.getClass().getSimpleName(), dItem.getId(), dItem.getDefaultPhoto(), gallery.getId());
        return null;
    }

    private Set<Drawing> getDrawings(DItem dItem) {
        Set<Drawing> drawings = new HashSet<>();
        Set<Graphics> graphicsSet = graphicsService.getGraphicsSet(dItem.getDrawings());

        for (Graphics graphics : graphicsSet) {
            if (MediaType.DRAWING.equals(graphics.getType())) {
                drawings.add((Drawing) graphics);
            } else {
                LOGGER.warn("getDrawings() - DB inconsistency found for DItem with ID = {}: Drawing with ID = {} is not Drawing but {}", dItem.getId(), graphics.getId(), graphics.getType());
            }
        }

        return drawings;
    }

    private DItem toDItem(Item item) {
        DItem dItem = new DItem();
        dItem.setId(item.getId());
        dItem.setInventoryNumber(item.getInventoryNumber());
        dItem.setName(item.getName());
        dItem.setAdditionalName(item.getAdditionalName());
        dItem.setCategory(item.getCategory());
        dItem.setDefaultPhoto(item.getDefaultPhoto() == null ? null : item.getDefaultPhoto().getId());
        dItem.setStatus(item.getStatus());
        dItem.setDescription(item.getDescription());
        dItem.setLabels(item.getLabels());
        dItem.setDrawings(item.getDrawings() == null ? null : item.getDrawings().stream().map(Drawing::getId).collect(Collectors.toSet()));
        dItem.setDimensions(item.getDimensions() == null ? null : item.getDimensions().stream().map(Dimension::getId).collect(Collectors.toSet()));
        dItem.setMaterial(item.getMaterial() == null ? null : item.getMaterial().stream().map(Material::getId).collect(Collectors.toSet()));
        dItem.setLocation(item.getLocation() == null ? null : item.getLocation().getId());
        dItem.setOwner(item.getOwner() == null ? null : item.getOwner().getId());
        dItem.setCurrentConditions(item.getCurrentConditions() == null ? null : item.getCurrentConditions().getId());
        dItem.setComments(item.getComments());
        dItem.setManufactureDate(item.getManufactureDate());
        dItem.setManufacturers(item.getManufacturers() == null ? null : item.getManufacturers().stream().map(Subject::getId).collect(Collectors.toSet()));
        dItem.setAcquisition(item.getAcquisition() == null ? null : item.getAcquisition().getId());
        dItem.setAcquisitionCondition(item.getAcquisitionCondition() == null ? null : item.getAcquisitionCondition().getId());
        dItem.setDefaultGallery(item.getDefaultGallery() == null ? null : item.getDefaultGallery().getId());
        dItem.setGalleries(item.getGalleries() == null ? null : item.getGalleries().stream().map(ImageGallery::getId).collect(Collectors.toSet()));
        dItem.setAudio(item.getAudio() == null ? null : item.getAudio().stream().map(Audio::getId).collect(Collectors.toSet()));
        dItem.setVideo(item.getVideo() == null ? null : item.getVideo().stream().map(Video::getId).collect(Collectors.toSet()));
        dItem.setFiles(item.getFiles() == null ? null : item.getFiles().stream().map(File::getId).collect(Collectors.toSet()));
        dItem.setLinks(item.getLinks() == null ? null : item.getLinks().stream().map(Link::getId).collect(Collectors.toSet()));
        dItem.setExtensions(item.getExtensions() == null ? null : item.getExtensions().stream().map(Extension::getId).collect(Collectors.toSet()));
        dItem.setAccessories(item.getAccessories() == null ? null : item.getAccessories().stream().map(Accessory::getId).collect(Collectors.toSet()));

        return dItem;
    }
}
