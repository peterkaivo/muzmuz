package io.github.peterkaivo.muzmuz.dataservice.model;

import io.github.peterkaivo.muzmuz.common.types.MediaType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Data class for media content info from a file
 */
@Entity
@Table(name = "FILE")
public class DFile extends DMedium {

    public DFile() {
    }

    public DFile(Long id, String name, String fileName, String description, String comments) {
        super(id, MediaType.FILE, name, fileName, description, comments);
    }

    @Override
    public String toString() {
        return "DFile{} " + super.toString();
    }
}
