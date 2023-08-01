package io.github.peterkaivo.muzmuz.service.model;

import io.github.peterkaivo.muzmuz.common.types.MediaType;

import java.util.Objects;

/**
 * Root parent view class for media content info
 */
public abstract class Medium {
    private Long id;
    private MediaType type;
    private String name;
    private String fileName;
    private String description;
    private String comments;

    public Medium() {
    }

    public Medium(Long id, MediaType type, String name, String fileName, String description, String comments) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.fileName = fileName;
        this.description = description;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MediaType getType() {
        return type;
    }

    public void setType(MediaType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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
        Medium medium = (Medium) o;
        return Objects.equals(id, medium.id)
                && type == medium.type
                && Objects.equals(name, medium.name)
                && Objects.equals(fileName, medium.fileName)
                && Objects.equals(description, medium.description)
                && Objects.equals(comments, medium.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, name, fileName, description, comments);
    }

    @Override
    public String toString() {
        return "Medium{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", fileName='" + fileName + '\'' +
                ", description='" + description + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
