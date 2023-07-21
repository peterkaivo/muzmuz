package io.github.peterkaivo.muzmuz.dataservice.model;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * Data cLass representing an information and description of a string of stringed instrument
 */
@Entity
@Table(name = "STRING_INFO")
public class DStringInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int stringOrder;
    private String pitch;
    private Long thickness;
    private Long material;
    @Lob
    private String description;
    @Lob
    private String comments;

    public DStringInfo() {
    }

    public DStringInfo(Long id, int stringOrder, String pitch, Long thickness, Long material, String description,
                       String comments) {
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

    public Long getThickness() {
        return thickness;
    }

    public void setThickness(Long thickness) {
        this.thickness = thickness;
    }

    public Long getMaterial() {
        return material;
    }

    public void setMaterial(Long material) {
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
        DStringInfo dStringInfo = (DStringInfo) o;
        return stringOrder == dStringInfo.stringOrder
                && Objects.equals(id, dStringInfo.id)
                && Objects.equals(pitch, dStringInfo.pitch)
                && Objects.equals(thickness, dStringInfo.thickness)
                && Objects.equals(material, dStringInfo.material)
                && Objects.equals(description, dStringInfo.description)
                && Objects.equals(comments, dStringInfo.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stringOrder, pitch, thickness, material, description, comments);
    }

    @Override
    public String toString() {
        return "DStringInfo{" +
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
