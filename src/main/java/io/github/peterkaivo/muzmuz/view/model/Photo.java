package io.github.peterkaivo.muzmuz.view.model;

import io.github.peterkaivo.muzmuz.common.types.MediaType;

import java.util.Date;

/**
 * View class for photo media content info
 */
public class Photo extends Graphics {
    public Photo() {
    }

    public Photo(Long id, String name, String fileName, String description, String comments, Resolution resolution,
                 Date acquired) {
        super(id, MediaType.PHOTO, name, fileName, description, comments, resolution, acquired);
    }

    @Override
    public String toString() {
        return "Photo{} " + super.toString();
    }
}
