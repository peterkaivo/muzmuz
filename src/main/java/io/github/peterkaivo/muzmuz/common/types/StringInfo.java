package io.github.peterkaivo.muzmuz.common.types;

import java.util.Objects;

/**
 * CLass representing an information and description of a string of stringed instrument
 */
public class StringInfo {
    Integer order;
    String pitch;
    Dimension thickness;
    Material material;

    public StringInfo(Integer order, String pitch, Dimension thickness, Material material) {
        this.order = order;
        this.pitch = pitch;
        this.thickness = thickness;
        this.material = material;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getPitch() {
        return pitch;
    }

    public void setPitch(String pitch) {
        this.pitch = pitch;
    }

    public Dimension getThickness() {
        return thickness;
    }

    public void setThickness(Dimension thickness) {
        this.thickness = thickness;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringInfo that = (StringInfo) o;
        return Objects.equals(order, that.order) && Objects.equals(pitch, that.pitch) && Objects.equals(thickness, that.thickness) && Objects.equals(material, that.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, pitch, thickness, material);
    }

    @Override
    public String toString() {
        return "StringInfo{" +
                "order=" + order +
                ", pitch='" + pitch + '\'' +
                ", thickness=" + thickness +
                ", material=" + material +
                '}';
    }
}
