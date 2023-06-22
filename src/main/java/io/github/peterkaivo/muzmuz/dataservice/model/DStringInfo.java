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
    private int order;
    private String pitch;
    private Long thickness;
    private Long material;

    public DStringInfo() {
    }

    public DStringInfo(Long id, int order, String pitch, Long thickness, Long material) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DStringInfo dStringInfo = (DStringInfo) o;
        return order == dStringInfo.order
                && Objects.equals(id, dStringInfo.id)
                && Objects.equals(pitch, dStringInfo.pitch)
                && Objects.equals(thickness, dStringInfo.thickness)
                && Objects.equals(material, dStringInfo.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, order, pitch, thickness, material);
    }

    @Override
    public String toString() {
        return "DStringInfo{" +
                "id=" + id +
                ", order=" + order +
                ", pitch='" + pitch + '\'' +
                ", thickness=" + thickness +
                ", material=" + material +
                '}';
    }
}
