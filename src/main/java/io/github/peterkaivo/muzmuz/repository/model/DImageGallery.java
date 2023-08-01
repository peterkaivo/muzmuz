package io.github.peterkaivo.muzmuz.repository.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Data class representing an image gallery and its description
 */
@Entity
@Table(name = "IMAGE_GALLERY")
public class DImageGallery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Set<Long> images = new HashSet<>();
    @Lob
    private String description;
    @Lob
    private String comments;

    public DImageGallery() {
    }

    public DImageGallery(Long id, String name, Set<Long> images, String description, String comments) {
        this.id = id;
        this.name = name;
        this.images = images;
        this.description = description;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Long> getImages() {
        return images;
    }

    public void setImages(Set<Long> images) {
        this.images = images;
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
        DImageGallery dImageGallery = (DImageGallery) o;
        return Objects.equals(id, dImageGallery.id)
                && Objects.equals(name, dImageGallery.name)
                && Objects.equals(images, dImageGallery.images)
                && Objects.equals(description, dImageGallery.description)
                && Objects.equals(comments, dImageGallery.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, images, description, comments);
    }

    @Override
    public String toString() {
        return "DImageGallery{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", images=" + images +
                ", description='" + description + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
