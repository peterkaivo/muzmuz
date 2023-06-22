package io.github.peterkaivo.muzmuz.dataservice.model;

import io.github.peterkaivo.muzmuz.common.types.MediaType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Date;

/**
 * Data class for drawing media content info
 */
@Entity
@DiscriminatorValue("Drawing")
public class DDrawing extends DGraphics {
    public DDrawing() {
    }

    public DDrawing(Long id, String name, String fileName, String description, String comments, Long resolution,
                    Date acquired) {
        super(id, MediaType.DRAWING, name, fileName, description, comments, resolution, acquired);
    }

    @Override
    public String toString() {
        return "DDrawing{} " + super.toString();
    }
}
