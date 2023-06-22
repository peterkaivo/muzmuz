package io.github.peterkaivo.muzmuz.dataservice.model;

import io.github.peterkaivo.muzmuz.common.types.Compactness;
import io.github.peterkaivo.muzmuz.common.types.ConditionStatus;
import jakarta.persistence.*;

import java.util.Objects;

/**
 * Data class for item condition description
 */
@Entity
@Table(name = "CONDITIONS")
public class DConditions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private ConditionStatus conditionStatus;
    @Enumerated(EnumType.STRING)
    private Compactness compactness;
    @Lob
    private String description;
    @Lob
    private String comments;

    public DConditions() {
    }

    public DConditions(Long id, ConditionStatus conditionStatus, Compactness compactness, String description,
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
        DConditions dConditions = (DConditions) o;
        return Objects.equals(id, dConditions.id)
                && conditionStatus == dConditions.conditionStatus
                && compactness == dConditions.compactness
                && Objects.equals(description, dConditions.description)
                && Objects.equals(comments, dConditions.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, conditionStatus, compactness, description, comments);
    }

    @Override
    public String toString() {
        return "DConditions{" +
                "id=" + id +
                ", conditionStatus=" + conditionStatus +
                ", compactness=" + compactness +
                ", description='" + description + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
