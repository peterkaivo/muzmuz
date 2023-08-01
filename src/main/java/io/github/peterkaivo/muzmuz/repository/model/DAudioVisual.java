package io.github.peterkaivo.muzmuz.repository.model;

import io.github.peterkaivo.muzmuz.common.types.MediaType;
import jakarta.persistence.MappedSuperclass;

import java.util.Objects;

/**
 * Parent data class for audiovisual media content info
 */
@MappedSuperclass
public abstract class DAudioVisual extends DMedium {
    private String length;

    public DAudioVisual() {
    }

    public DAudioVisual(Long id, MediaType type, String name, String fileName, String description, String comments,
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
        DAudioVisual dAudioVisual = (DAudioVisual) o;
        return Objects.equals(length, dAudioVisual.length);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), length);
    }

    @Override
    public String toString() {
        return "DAudioVisual{" +
                "length='" + length + '\'' +
                "} " + super.toString();
    }
}
