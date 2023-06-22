package io.github.peterkaivo.muzmuz.view.model;

import java.util.Objects;

/**
 * View class representing a digital image resolution
 */
public class Resolution {
    private Long id;
    private Dimension width;
    private Dimension height;

    public Resolution() {
    }

    public Resolution(Long id, Dimension width, Dimension height) {
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

    public Dimension getWidth() {
        return width;
    }

    public void setWidth(Dimension width) {
        this.width = width;
    }

    public Dimension getHeight() {
        return height;
    }

    public void setHeight(Dimension height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resolution resolution = (Resolution) o;
        return Objects.equals(id, resolution.id)
                && Objects.equals(width, resolution.width)
                && Objects.equals(height, resolution.height);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, width, height);
    }

    @Override
    public String toString() {
        return "Resolution{" +
                "id=" + id +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
