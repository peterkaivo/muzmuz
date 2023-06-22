package io.github.peterkaivo.muzmuz.view.model;

import io.github.peterkaivo.muzmuz.common.types.DimensionType;
import io.github.peterkaivo.muzmuz.common.types.Unit;

import java.util.Objects;

/**
 * View class representing and describing a measurable dimension
 */
public class Dimension {
    private Long id;
    private DimensionType type;
    private float value;
    private Unit unit;
    private String description;
    private String comments;

    public Dimension() {
    }

    public Dimension(Long id, DimensionType type, float value, Unit unit, String description, String comments) {
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
        Dimension dimension = (Dimension) o;
        return Float.compare(dimension.value, value) == 0
                && Objects.equals(id, dimension.id)
                && type == dimension.type
                && unit == dimension.unit
                && Objects.equals(description, dimension.description)
                && Objects.equals(comments, dimension.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, value, unit, description, comments);
    }

    @Override
    public String toString() {
        return "Dimension{" +
                "id=" + id +
                ", type=" + type +
                ", value=" + value +
                ", unit=" + unit +
                ", description='" + description + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
