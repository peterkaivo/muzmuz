package io.github.peterkaivo.muzmuz.service.model;

import io.github.peterkaivo.muzmuz.common.types.MediaType;

import java.util.Objects;

/**
 * Parent view class for graphics media content info
 */
public abstract class Graphics extends Medium {
    private String resolution;
    private String acquired;

    public Graphics() {
    }

    public Graphics(Long id, MediaType type, String name, String fileName, String description, String comments,
                    String resolution, String acquired) {
        super(id, type, name, fileName, description, comments);
        this.resolution = resolution;
        this.acquired = acquired;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getAcquired() {
        return acquired;
    }

    public void setAcquired(String acquired) {
        this.acquired = acquired;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Graphics graphics = (Graphics) o;
        return Objects.equals(resolution, graphics.resolution)
                && Objects.equals(acquired, graphics.acquired);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), resolution, acquired);
    }

    @Override
    public String toString() {
        return "Graphics{" +
                "resolution=" + resolution +
                ", acquired=" + acquired +
                "} " + super.toString();
    }
}
