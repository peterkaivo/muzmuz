package io.github.peterkaivo.muzmuz.dataservice.model;

import io.github.peterkaivo.muzmuz.common.types.DimensionType;
import io.github.peterkaivo.muzmuz.common.types.Unit;
import jakarta.persistence.*;

import java.util.Objects;

/**
 * Data class representing and describing a measurable dimension
 */
@Entity
@Table(name = "DIMENSION")
public class DDimension {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private DimensionType type;
    private float value;
    @Enumerated(EnumType.STRING)
    private Unit unit;
    @Lob
    private String description;
    @Lob
    private String comments;

    public DDimension() {
    }

    public DDimension(Long id, DimensionType type, float value, Unit unit, String description, String comments) {
        this.id = id;
        this.type = type;
        this.value = value;
        this.unit = unit;
        this.description = description;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DimensionType getType() {
        return type;
    }

    public void setType(DimensionType type) {
        this.type = type;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
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
        DDimension dDimension = (DDimension) o;
        return Float.compare(dDimension.value, value) == 0
                && Objects.equals(id, dDimension.id)
                && type == dDimension.type
                && unit == dDimension.unit
                && Objects.equals(description, dDimension.description)
                && Objects.equals(comments, dDimension.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, value, unit, description, comments);
    }

    @Override
    public String toString() {
        return "DDimension{" +
                "id=" + id +
                ", type=" + type +
                ", value=" + value +
                ", unit=" + unit +
                ", description='" + description + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
