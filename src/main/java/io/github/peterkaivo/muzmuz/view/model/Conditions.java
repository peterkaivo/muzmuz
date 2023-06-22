package io.github.peterkaivo.muzmuz.view.model;

import io.github.peterkaivo.muzmuz.common.types.Compactness;
import io.github.peterkaivo.muzmuz.common.types.ConditionStatus;

import java.util.Objects;

/**
 * View class for item condition description
 */
public class Conditions {
    private Long id;
    private ConditionStatus conditionStatus;
    private Compactness compactness;
    private String description;
    private String comments;

    public Conditions() {
    }

    public Conditions(Long id, ConditionStatus conditionStatus, Compactness compactness, String description,
                      String comments) {
        this.id = id;
        this.conditionStatus = conditionStatus;
        this.compactness = compactness;
        this.description = description;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ConditionStatus getConditionStatus() {
        return conditionStatus;
    }

    public void setConditionStatus(ConditionStatus conditionStatus) {
        this.conditionStatus = conditionStatus;
    }

    public Compactness getCompactness() {
        return compactness;
    }

    public void setCompactness(Compactness compactness) {
        this.compactness = compactness;
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
        Conditions conditions = (Conditions) o;
        return Objects.equals(id, conditions.id)
                && conditionStatus == conditions.conditionStatus
                && compactness == conditions.compactness
                && Objects.equals(description, conditions.description)
                && Objects.equals(comments, conditions.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, conditionStatus, compactness, description, comments);
    }

    @Override
    public String toString() {
        return "Conditions{" +
                "id=" + id +
                ", conditionStatus=" + conditionStatus +
                ", compactness=" + compactness +
                ", description='" + description + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
