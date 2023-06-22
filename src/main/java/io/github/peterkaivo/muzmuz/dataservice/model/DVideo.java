package io.github.peterkaivo.muzmuz.dataservice.model;

import io.github.peterkaivo.muzmuz.common.types.MediaType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;
import java.util.Objects;

/**
 * Data class for video media content info
 */
@Entity
@Table(name = "VIDEO")
public class DVideo extends DAudioVisual {

    private Long resolution;
    @Temporal(TemporalType.DATE)
    private Date acquired;

    public DVideo() {
    }

    public DVideo(Long id, String name, String fileName, String description, String comments, String length,
                  Long resolution, Date acquired) {
        super(id, MediaType.VIDEO, name, fileName, description, comments, length);
        this.resolution = resolution;
        this.acquired = acquired;
    }

    public Long getResolution() {
        return resolution;
    }

    public void setResolution(Long resolution) {
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
