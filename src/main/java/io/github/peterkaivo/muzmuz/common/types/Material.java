package io.github.peterkaivo.muzmuz.common.types;

import java.util.Objects;

/**
 * Class representing and describing a physical material
 */
public class Material {
    MaterialCategory category;
    String type;
    String description;
    String comments;

    public Material(MaterialCategory category, String type, String description, String comments) {
        this.category = category;
        this.type = type;
        this.description = description;
        this.comments = comments;
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
        return category == material.category && Objects.equals(type, material.type) && Objects.equals(description, material.description) && Objects.equals(comments, material.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, type, description, comments);
    }

    @Override
    public String toString() {
        return "Material{" +
                "category=" + category +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
