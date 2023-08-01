package io.github.peterkaivo.muzmuz.service.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Class representing an image gallery and its description
 */
public class ImageGallery {
    private Long id;
    private String name;
    private Set<Graphics> images = new HashSet<>();
    private String description;
    private String comments;

    public ImageGallery() {
    }

    public ImageGallery(Long id, String name, Set<Graphics> images, String description, String comments) {
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

    public Set<Graphics> getImages() {
        return images;
    }

    public void setImages(Set<Graphics> images) {
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
        ImageGallery imageGallery = (ImageGallery) o;
        return Objects.equals(id, imageGallery.id)
                && Objects.equals(name, imageGallery.name)
                && Objects.equals(images, imageGallery.images)
                && Objects.equals(description, imageGallery.description)
                && Objects.equals(comments, imageGallery.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, images, description, comments);
    }

    @Override
    public String toString() {
        return "ImageGallery{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", images=" + images +
                ", description='" + description + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
