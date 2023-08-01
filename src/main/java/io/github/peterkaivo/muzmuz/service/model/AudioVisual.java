package io.github.peterkaivo.muzmuz.service.model;

import io.github.peterkaivo.muzmuz.common.types.MediaType;

import java.util.Objects;

/**
 * Parent view class for audiovisual media content info
 */
public abstract class AudioVisual extends Medium {
    private String length;

    public AudioVisual() {
    }

    public AudioVisual(Long id, MediaType type, String name, String fileName, String description, String comments,
                       String length) {
        super(id, type, name, fileName, description, comments);
        this.length = length;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AudioVisual audioVisual = (AudioVisual) o;
        return Objects.equals(length, audioVisual.length);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), length);
    }

    @Override
    public String toString() {
        return "AudioVisual{" +
                "length='" + length + '\'' +
                "} " + super.toString();
    }
}
