package io.github.peterkaivo.muzmuz.view.model;

import io.github.peterkaivo.muzmuz.common.types.MediaType;

/**
 * View class for drawing media content info
 */
public class Drawing extends Graphics {
    public Drawing() {
    }

    public Drawing(Long id, String name, String fileName, String description, String comments, String resolution,
                   String acquired) {
        super(id, MediaType.DRAWING, name, fileName, description, comments, resolution, acquired);
    }

    @Override
    public String toString() {
        return "Drawing{} " + super.toString();
    }
}
