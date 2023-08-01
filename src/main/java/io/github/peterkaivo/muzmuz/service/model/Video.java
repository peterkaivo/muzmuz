package io.github.peterkaivo.muzmuz.service.model;

import io.github.peterkaivo.muzmuz.common.types.MediaType;

import java.util.Objects;

/**
 * View class for video media content info
 */
public class Video extends AudioVisual {

    private String resolution;
    private String acquired;

    public Video() {
    }

    public Video(Long id, String name, String fileName, String description, String comments, String length,
                 String resolution, String acquired) {
        super(id, MediaType.VIDEO, name, fileName, description, comments, length);
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
        Video video = (Video) o;
        return Objects.equals(resolution, video.resolution)
                && Objects.equals(acquired, video.acquired);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), resolution, acquired);
    }

    @Override
    public String toString() {
        return "Video{" +
                "resolution=" + resolution +
                ", acquired=" + acquired +
                "} " + super.toString();
    }
}
