package io.github.peterkaivo.muzmuz.repository.model;

import io.github.peterkaivo.muzmuz.common.types.MediaType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * Data class for drawing media content info
 */
@Entity
@DiscriminatorValue("Drawing")
public class DDrawing extends DGraphics {
    public DDrawing() {
    }

    public DDrawing(Long id, String name, String fileName, String description, String comments, String resolution,
                    String acquired) {
        super(id, MediaType.DRAWING, name, fileName, description, comments, resolution, acquired);
    }

    @Override
    public String toString() {
        return "DDrawing{} " + super.toString();
    }
}
