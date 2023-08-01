package io.github.peterkaivo.muzmuz.service;

import io.github.peterkaivo.muzmuz.common.exceptions.ItemNotFoundException;
import io.github.peterkaivo.muzmuz.service.model.ImageGallery;

import java.util.List;

/**
 * Service class handling {@link io.github.peterkaivo.muzmuz.service.model.ImageGallery}
 */
public interface ImageGalleryService {
    public List<ImageGallery> getAllImageGalleries();
    public ImageGallery getImageGallery(Long id) throws ItemNotFoundException;
    public ImageGallery saveImageGallery(ImageGallery acquisition);
}
