package io.github.peterkaivo.muzmuz.repository.model;

import io.github.peterkaivo.muzmuz.common.types.MediaType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * Data class for photo media content info
 */
@Entity
@DiscriminatorValue("Photo")
public class DPhoto extends DGraphics {
    public DPhoto() {
    }

    public DPhoto(Long id, String name, String fileName, String description, String comments, String resolution,
                  String acquired) {
        super(id, MediaType.PHOTO, name, fileName, description, comments, resolution, acquired);
    }

    @Override
    public String toString() {
        return "DPhoto{} " + super.toString();
    }
}
