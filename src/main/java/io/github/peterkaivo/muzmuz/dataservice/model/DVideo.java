package io.github.peterkaivo.muzmuz.dataservice.model;

import io.github.peterkaivo.muzmuz.common.types.MediaType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

/**
 * Data class for video media content info
 */
@Entity
@Table(name = "VIDEO")
public class DVideo extends DAudioVisual {

    private String resolution;
    private String acquired;

    public DVideo() {
    }

    public DVideo(Long id, String name, String fileName, String description, String comments, String length,
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
        DVideo dVideo = (DVideo) o;
        return Objects.equals(resolution, dVideo.resolution)
                && Objects.equals(acquired, dVideo.acquired);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), resolution, acquired);
    }

    @Override
    public String toString() {
        return "DVideo{" +
                "resolution=" + resolution +
                ", acquired=" + acquired +
                "} " + super.toString();
    }
}
