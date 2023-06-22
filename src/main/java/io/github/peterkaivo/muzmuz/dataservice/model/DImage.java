package io.github.peterkaivo.muzmuz.dataservice.model;

import io.github.peterkaivo.muzmuz.common.types.MediaType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Date;

/**
 * Data class for image media content info
 */
@Entity
@DiscriminatorValue("Image")
public class DImage extends DGraphics {
    public DImage() {
    }

    public DImage(Long id, String name, String fileName, String description, String comments, Long resolution,
                  Date acquired) {
        super(id, MediaType.IMAGE, name, fileName, description, comments, resolution, acquired);
    }

    @Override
    public String toString() {
        return "DImage{} " + super.toString();
    }
}
