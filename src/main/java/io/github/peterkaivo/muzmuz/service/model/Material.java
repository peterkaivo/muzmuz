package io.github.peterkaivo.muzmuz.service.model;

import io.github.peterkaivo.muzmuz.common.types.MaterialCategory;

import java.util.Objects;

/**
 * View class representing and describing a physical material
 */
public class Material {
    private Long id;
    private MaterialCategory category;
    private String type;
    private String description;
    private String comments;

    public Material() {
    }

    public Material(Long id, MaterialCategory category, String type, String description, String comments) {
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
        Material material = (Material) o;
        return Objects.equals(id, material.id)
                && category == material.category
                && Objects.equals(type, material.type)
                && Objects.equals(description, material.description)
                && Objects.equals(comments, material.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, type, description, comments);
    }

    @Override
    public String toString() {
        return "Material{" +
                "Id=" + id +
                ", category=" + category +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
