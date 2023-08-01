package io.github.peterkaivo.muzmuz.service.model;

import io.github.peterkaivo.muzmuz.common.types.MediaType;

/**
 * View class for media content info from a file
 */
public class File extends Medium {

    public File() {
    }

    public File(Long id, String name, String fileName, String description, String comments) {
        super(id, MediaType.FILE, name, fileName, description, comments);
    }

    @Override
    public String toString() {
        return "File{} " + super.toString();
    }
}
