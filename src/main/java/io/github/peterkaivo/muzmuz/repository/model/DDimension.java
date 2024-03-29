package io.github.peterkaivo.muzmuz.repository.model;

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
    private DimensionType dimensionType;
    private float dimensionValue;
    @Enumerated(EnumType.STRING)
    private Unit unit;
    @Lob
    private String description;
    @Lob
    private String comments;

    public DDimension() {
    }

    public DDimension(Long id, DimensionType dimensionType, float dimensionValue, Unit unit, String description, String comments) {
        this.id = id;
        this.dimensionType = dimensionType;
        this.dimensionValue = dimensionValue;
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

    public DimensionType getDimensionType() {
        return dimensionType;
    }

    public void setDimensionType(DimensionType dimensionType) {
        this.dimensionType = dimensionType;
    }

    public float getDimensionValue() {
        return dimensionValue;
    }

    public void setDimensionValue(float dimensionValue) {
        this.dimensionValue = dimensionValue;
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
        return Float.compare(dDimension.dimensionValue, dimensionValue) == 0
                && Objects.equals(id, dDimension.id)
                && dimensionType == dDimension.dimensionType
                && unit == dDimension.unit
                && Objects.equals(description, dDimension.description)
                && Objects.equals(comments, dDimension.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dimensionType, dimensionValue, unit, description, comments);
    }

    @Override
    public String toString() {
        return "DDimension{" +
                "id=" + id +
                ", type=" + dimensionType +
                ", value=" + dimensionValue +
                ", unit=" + unit +
                ", description='" + description + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
