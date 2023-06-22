package io.github.peterkaivo.muzmuz.dataservice.model;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * Data class representing a digital image resolution
 */
@Entity
@Table(name = "RESOLUTION")
public class DResolution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long width;
    private Long height;

    public DResolution() {
    }

    public DResolution(Long id, Long width, Long height) {
        this.id = id;
        this.width = width;
        this.height = height;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWidth() {
        return width;
    }

    public void setWidth(Long width) {
        this.width = width;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DResolution dResolution = (DResolution) o;
        return Objects.equals(id, dResolution.id)
                && Objects.equals(width, dResolution.width)
                && Objects.equals(height, dResolution.height);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, width, height);
    }

    @Override
    public String toString() {
        return "DResolution{" +
                "id=" + id +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
