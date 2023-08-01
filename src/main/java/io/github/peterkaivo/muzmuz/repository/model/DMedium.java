package io.github.peterkaivo.muzmuz.repository.model;

import io.github.peterkaivo.muzmuz.common.types.MediaType;
import jakarta.persistence.*;

import java.util.Objects;

/**
 * Root parent data class for media content info
 */
@MappedSuperclass
public abstract class DMedium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private MediaType type;
    private String name;
    private String fileName;
    @Lob
    private String description;
    @Lob
    private String comments;

    public DMedium() {
    }

    public DMedium(Long id, MediaType type, String name, String fileName, String description, String comments) {
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
        DMedium dMedium = (DMedium) o;
        return Objects.equals(id, dMedium.id)
                && type == dMedium.type
                && Objects.equals(name, dMedium.name)
                && Objects.equals(fileName, dMedium.fileName)
                && Objects.equals(description, dMedium.description)
                && Objects.equals(comments, dMedium.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, name, fileName, description, comments);
    }

    @Override
    public String toString() {
        return "DMedium{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", fileName='" + fileName + '\'' +
                ", description='" + description + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
