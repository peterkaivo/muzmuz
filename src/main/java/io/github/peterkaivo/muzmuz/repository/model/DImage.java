package io.github.peterkaivo.muzmuz.repository.model;

import io.github.peterkaivo.muzmuz.common.types.MediaType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * Data class for image media content info
 */
@Entity
@DiscriminatorValue("Image")
public class DImage extends DGraphics {
    public DImage() {
    }

    public DImage(Long id, String name, String fileName, String description, String comments, String resolution,
                  String acquired) {
        super(id, MediaType.IMAGE, name, fileName, description, comments, resolution, acquired);
    }

    @Override
    public String toString() {
        return "DImage{} " + super.toString();
    }
}
