package io.github.peterkaivo.muzmuz.view.model;

import io.github.peterkaivo.muzmuz.common.types.MediaType;

import java.util.Date;
import java.util.Objects;

/**
 * View class for video media content info
 */
public class Video extends AudioVisual {

    private Resolution resolution;
    private Date acquired;

    public Video() {
    }

    public Video(Long id, String name, String fileName, String description, String comments, String length,
                 Resolution resolution, Date acquired) {
        super(id, MediaType.VIDEO, name, fileName, description, comments, length);
        this.resolution = resolution;
        this.acquired = acquired;
    }

    public Resolution getResolution() {
        return resolution;
    }

    public void setResolution(Resolution resolution) {
        this.resolution = resolution;
    }

    public Date getAcquired() {
        return acquired;
    }

    public void setAcquired(Date acquired) {
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
