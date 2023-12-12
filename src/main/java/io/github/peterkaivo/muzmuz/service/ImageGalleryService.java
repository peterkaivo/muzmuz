package io.github.peterkaivo.muzmuz.service;

import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundException;
import io.github.peterkaivo.muzmuz.service.model.ImageGallery;

import java.util.List;
import java.util.Set;

/**
 * Service class handling {@link io.github.peterkaivo.muzmuz.service.model.ImageGallery}
 */
public interface ImageGalleryService {
    public List<ImageGallery> getAllImageGalleries();
    public ImageGallery getImageGallery(Long id) throws DBObjectNotFoundException;
    public Set<ImageGallery> getImageGalleries(Set<Long> ids);
    public ImageGallery saveImageGallery(ImageGallery imageGallery);
}
