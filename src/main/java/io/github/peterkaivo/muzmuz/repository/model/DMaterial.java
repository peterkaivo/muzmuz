package io.github.peterkaivo.muzmuz.repository.model;

import io.github.peterkaivo.muzmuz.common.types.MaterialCategory;
import jakarta.persistence.*;

import java.util.Objects;

/**
 * Data class representing and describing a physical material
 */
@Entity
@Table(name = "MATERIAL")
public class DMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private MaterialCategory category;
    private String type;
    @Lob
    private String description;
    @Lob
    private String comments;

    public DMaterial() {
    }

    public DMaterial(Long id, MaterialCategory category, String type, String description, String comments) {
        this.id = id;
        this.category = category;
        this.type = type;
        this.description = description;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MaterialCategory getCategory() {
        return category;
    }

    public void setCategory(MaterialCategory category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        DMaterial dMaterial = (DMaterial) o;
        return Objects.equals(id, dMaterial.id)
                && category == dMaterial.category
                && Objects.equals(type, dMaterial.type)
                && Objects.equals(description, dMaterial.description)
                && Objects.equals(comments, dMaterial.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, type, description, comments);
    }

    @Override
    public String toString() {
        return "DMaterial{" +
                "Id=" + id +
                ", category=" + category +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
