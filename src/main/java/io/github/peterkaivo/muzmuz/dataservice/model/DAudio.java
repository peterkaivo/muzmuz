package io.github.peterkaivo.muzmuz.dataservice.model;

import io.github.peterkaivo.muzmuz.common.types.MediaType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Data class for audio media content info
 */
@Entity
@Table(name = "AUDIO")
public class DAudio extends DAudioVisual {
    public DAudio() {
    }

    public DAudio(Long id, String name, String fileName, String description, String comments, String length) {
        super(id, MediaType.AUDIO, name, fileName, description, comments, length);
    }

    @Override
    public String toString() {
        return "DAudio{} " + super.toString();
    }
}
