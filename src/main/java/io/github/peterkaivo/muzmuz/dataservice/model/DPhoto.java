package io.github.peterkaivo.muzmuz.dataservice.model;

import io.github.peterkaivo.muzmuz.common.types.MediaType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Date;

/**
 * Data class for photo media content info
 */
@Entity
@DiscriminatorValue("Photo")
public class DPhoto extends DGraphics {
    public DPhoto() {
    }

    public DPhoto(Long id, String name, String fileName, String description, String comments, Long resolution,
                  Date acquired) {
        super(id, MediaType.PHOTO, name, fileName, description, comments, resolution, acquired);
    }

    @Override
    public String toString() {
        return "DPhoto{} " + super.toString();
    }
}
