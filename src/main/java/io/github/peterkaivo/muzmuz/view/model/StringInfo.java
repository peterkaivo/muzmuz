package io.github.peterkaivo.muzmuz.view.model;

import java.util.Objects;

/**
 * View cLass representing an information and description of a string of stringed instrument
 */
public class StringInfo {
    private Long id;
    private int stringOrder;
    private String pitch;
    private Dimension thickness;
    private Material material;
    private String description;
    private String comments;

    public StringInfo() {
    }

    public StringInfo(Long id, int stringOrder, String pitch, Dimension thickness, Material material,
                      String description, String comments) {
        this.id = id;
        this.stringOrder = stringOrder;
        this.pitch = pitch;
        this.thickness = thickness;
        this.material = material;
        this.description = description;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStringOrder() {
        return stringOrder;
    }

    public void setStringOrder(int stringOrder) {
        this.stringOrder = stringOrder;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringInfo stringInfo = (StringInfo) o;
        return stringOrder == stringInfo.stringOrder
                && Objects.equals(id, stringInfo.id)
                && Objects.equals(pitch, stringInfo.pitch)
                && Objects.equals(thickness, stringInfo.thickness)
                && Objects.equals(material, stringInfo.material)
                && Objects.equals(description, stringInfo.description)
                && Objects.equals(comments, stringInfo.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stringOrder, pitch, thickness, material, description, comments);
    }

    @Override
    public String toString() {
        return "StringInfo{" +
                "id=" + id +
                ", order=" + stringOrder +
                ", pitch='" + pitch + '\'' +
                ", thickness=" + thickness +
                ", material=" + material +
                ", description='" + description + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
