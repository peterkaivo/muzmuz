package io.github.peterkaivo.muzmuz.view.model;

import java.util.Objects;

/**
 * View cLass representing an information and description of a string of stringed instrument
 */
public class StringInfo {
    private Long id;
    private int order;
    private String pitch;
    private Dimension thickness;
    private Material material;

    public StringInfo() {
    }

    public StringInfo(Long id, int order, String pitch, Dimension thickness, Material material) {
        this.id = id;
        this.order = order;
        this.pitch = pitch;
        this.thickness = thickness;
        this.material = material;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
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
        StringInfo stringInfo = (StringInfo) o;
        return order == stringInfo.order
                && Objects.equals(id, stringInfo.id)
                && Objects.equals(pitch, stringInfo.pitch)
                && Objects.equals(thickness, stringInfo.thickness)
                && Objects.equals(material, stringInfo.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, order, pitch, thickness, material);
    }

    @Override
    public String toString() {
        return "StringInfo{" +
                "id=" + id +
                ", order=" + order +
                ", pitch='" + pitch + '\'' +
                ", thickness=" + thickness +
                ", material=" + material +
                '}';
    }
}
