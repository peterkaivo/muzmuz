package io.github.peterkaivo.muzmuz.service.impl;

import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundException;
import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundExceptionSupplier;
import io.github.peterkaivo.muzmuz.repository.ImageGalleryRepository;
import io.github.peterkaivo.muzmuz.repository.model.DImageGallery;
import io.github.peterkaivo.muzmuz.service.GraphicsService;
import io.github.peterkaivo.muzmuz.service.ImageGalleryService;
import io.github.peterkaivo.muzmuz.service.model.Graphics;
import io.github.peterkaivo.muzmuz.service.model.ImageGallery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class ImageGalleryServiceImpl implements ImageGalleryService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ImageGalleryService.class);

    @Autowired
    ImageGalleryRepository imageGalleryRepository;
    @Autowired
    GraphicsService graphicsService;

    @Override
    @Transactional(readOnly = true)
    public List<ImageGallery> getAllImageGalleries() {
        List<DImageGallery> imageGalleries = (List<DImageGallery>) imageGalleryRepository.findAll();

        return imageGalleries.stream().map(this::fromDImageGallery).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ImageGallery getImageGallery(Long id) throws DBObjectNotFoundException {
        DImageGallery dImageGallery = imageGalleryRepository.findById(id).orElseThrow(new DBObjectNotFoundExceptionSupplier(DImageGallery.class, id));

        return fromDImageGallery(dImageGallery);
    }

    @Override
    @Transactional(readOnly = true)
    public Set<ImageGallery> getImageGalleries(Set<Long> ids) {
        Set<ImageGallery> imageGalleries = new HashSet<>();

        for (Long id : ids) {
            try {
                imageGalleries.add(getImageGallery(id));
            } catch (DBObjectNotFoundException e) {
                LOGGER.warn("getImageGalleries() - DB inconsistency found for DImageGallery with ID = {}", id);
                LOGGER.info(e.getMessage());
            }
        }

        return imageGalleries;
    }

    @Override
    public ImageGallery saveImageGallery(ImageGallery imageGallery) {
        imageGalleryRepository.save(toDImageGallery(imageGallery));

        return imageGallery;
    }

    private ImageGallery fromDImageGallery(DImageGallery dImageGallery) {
        ImageGallery imageGallery = new ImageGallery();
        imageGallery.setId(dImageGallery.getId());
        imageGallery.setName(dImageGallery.getName());
        imageGallery.setImages(dImageGallery.getImages() == null ? null : graphicsService.getGraphicsSet(dImageGallery.getImages()));
        imageGallery.setDescription(dImageGallery.getDescription());
        imageGallery.setComments(dImageGallery.getComments());

        return imageGallery;
    }

    private DImageGallery toDImageGallery(ImageGallery imageGallery) {
        DImageGallery dImageGallery = new DImageGallery();
        dImageGallery.setId(imageGallery.getId());
        dImageGallery.setName(imageGallery.getName());
        dImageGallery.setImages(imageGallery.getImages() == null ? null : imageGallery.getImages().stream().map(Graphics::getId).collect(Collectors.toSet()));
        dImageGallery.setDescription(imageGallery.getDescription());
        dImageGallery.setComments(imageGallery.getComments());

        return dImageGallery;
    }
}
