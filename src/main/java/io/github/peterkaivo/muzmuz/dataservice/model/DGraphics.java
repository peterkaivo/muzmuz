package io.github.peterkaivo.muzmuz.dataservice.model;

import io.github.peterkaivo.muzmuz.common.types.MediaType;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

/**
 * Parent data class for graphics media content info
 */
@Entity
@Table(name = "GRAPHICS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Graphics_Type")
public abstract class DGraphics extends DMedium {
    private Long resolution;
    @Temporal(TemporalType.DATE)
    private Date acquired;

    public DGraphics() {
    }

    public DGraphics(Long id, MediaType type, String name, String fileName, String description, String comments,
                     Long resolution, Date acquired) {
        super(id, type, name, fileName, description, comments);
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
        DGraphics dGraphics = (DGraphics) o;
        return Objects.equals(resolution, dGraphics.resolution)
                && Objects.equals(acquired, dGraphics.acquired);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), resolution, acquired);
    }

    @Override
    public String toString() {
        return "DGraphics{" +
                "resolution=" + resolution +
                ", acquired=" + acquired +
                "} " + super.toString();
    }
}
