package io.github.peterkaivo.muzmuz.repository.model;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * Data class representing and describing physical location
 */
@Entity
@Table(name = "LOCATION")
public class DLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long address;
    @Lob
    private String description;

    @Lob
    private String comments;

    public DLocation() {
    }

    public DLocation(Long id, String name, Long address, String description, String comments) {
        this.id = id;
        this.name = name;
        this.address = address;
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

    public Long getAddress() {
        return address;
    }

    public void setAddress(Long address) {
        this.address = address;
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
        DLocation dLocation = (DLocation) o;
        return Objects.equals(id, dLocation.id)
                && Objects.equals(name, dLocation.name)
                && Objects.equals(address, dLocation.address)
                && Objects.equals(description, dLocation.description)
                && Objects.equals(comments, dLocation.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, description, comments);
    }

    @Override
    public String toString() {
        return "DLocation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", description='" + description + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
