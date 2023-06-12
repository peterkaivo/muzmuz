package io.github.peterkaivo.muzmuz.common.types;

import java.util.Objects;

/**
 * Class representing a digital image resolution
 */
public class Resolution {
    Dimension width;
    Dimension height;

    public Resolution(Dimension width, Dimension height) {
        this.width = width;
        this.height = height;
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
        Resolution that = (Resolution) o;
        return Objects.equals(width, that.width) && Objects.equals(height, that.height);
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }

    @Override
    public String toString() {
        return "Resolution{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
