package io.github.peterkaivo.muzmuz.service.model;

import io.github.peterkaivo.muzmuz.common.types.MediaType;

/**
 * View class for image media content info
 */
public class Image extends Graphics {
    public Image() {
    }

    public Image(Long id, String name, String fileName, String description, String comments, String resolution,
                 String acquired) {
        super(id, MediaType.IMAGE, name, fileName, description, comments, resolution, acquired);
    }

    @Override
    public String toString() {
        return "Image{} " + super.toString();
    }
}
