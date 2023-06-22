package io.github.peterkaivo.muzmuz.view.model;

import io.github.peterkaivo.muzmuz.common.types.MediaType;

import java.util.Date;

/**
 * View class for image media content info
 */
public class Image extends Graphics {
    public Image() {
    }

    public Image(Long id, String name, String fileName, String description, String comments, Resolution resolution,
                 Date acquired) {
        super(id, MediaType.IMAGE, name, fileName, description, comments, resolution, acquired);
    }

    @Override
    public String toString() {
        return "Image{} " + super.toString();
    }
}
