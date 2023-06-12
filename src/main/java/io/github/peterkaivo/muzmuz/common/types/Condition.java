package io.github.peterkaivo.muzmuz.common.types;

import java.util.Objects;

/**
 * Class for item condition description
 */
public class Condition {
    ConditionStatus conditionStatus;
    Compactness compactness;
    String description;
    String comments;

    public Condition(ConditionStatus conditionStatus, Compactness compactness, String description, String comments) {
        this.conditionStatus = conditionStatus;
        this.compactness = compactness;
        this.description = description;
        this.comments = comments;
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
        Condition condition = (Condition) o;
        return conditionStatus == condition.conditionStatus && compactness == condition.compactness && Objects.equals(description, condition.description) && Objects.equals(comments, condition.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(conditionStatus, compactness, description, comments);
    }

    @Override
    public String toString() {
        return "Condition{" +
                "conditionStatus=" + conditionStatus +
                ", compactness=" + compactness +
                ", description='" + description + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
