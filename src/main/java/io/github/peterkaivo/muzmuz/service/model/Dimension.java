package io.github.peterkaivo.muzmuz.service.model;

import io.github.peterkaivo.muzmuz.common.types.DimensionType;
import io.github.peterkaivo.muzmuz.common.types.Unit;

import java.util.Objects;

/**
 * View class representing and describing a measurable dimension
 */
public class Dimension {
    private Long id;
    private DimensionType dimensionType;
    private float dimensionValue;
    private Unit unit;
    private String description;
    private String comments;

    public Dimension() {
    }

    public Dimension(Long id, DimensionType dimensionType, float dimensionValue, Unit unit, String description, String comments) {
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
        Dimension dimension = (Dimension) o;
        return Float.compare(dimension.dimensionValue, dimensionValue) == 0
                && Objects.equals(id, dimension.id)
                && dimensionType == dimension.dimensionType
                && unit == dimension.unit
                && Objects.equals(description, dimension.description)
                && Objects.equals(comments, dimension.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dimensionType, dimensionValue, unit, description, comments);
    }

    @Override
    public String toString() {
        return "Dimension{" +
                "id=" + id +
                ", type=" + dimensionType +
                ", value=" + dimensionValue +
                ", unit=" + unit +
                ", description='" + description + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
