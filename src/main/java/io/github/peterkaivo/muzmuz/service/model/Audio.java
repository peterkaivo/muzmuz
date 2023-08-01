package io.github.peterkaivo.muzmuz.service.model;

import io.github.peterkaivo.muzmuz.common.types.MediaType;

/**
 * View class for audio media content info
 */
public class Audio extends AudioVisual {
    public Audio() {
    }

    public Audio(Long id, String name, String fileName, String description, String comments, String length) {
        super(id, MediaType.AUDIO, name, fileName, description, comments, length);
    }

    @Override
    public String toString() {
        return "Audio{} " + super.toString();
    }
}
