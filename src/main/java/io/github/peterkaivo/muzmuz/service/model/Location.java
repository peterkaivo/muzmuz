package io.github.peterkaivo.muzmuz.service.model;

import java.util.Objects;

/**
 * View class representing and describing physical location
 */
public class Location {
    private Long id;
    private String name;
    private Address address;
    private String description;
    private String comments;

    public Location() {
    }

    public Location(Long id, String name, Address address, String description, String comments) {
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
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
        Location location = (Location) o;
        return Objects.equals(id, location.id)
                && Objects.equals(name, location.name)
                && Objects.equals(address, location.address)
                && Objects.equals(description, location.description)
                && Objects.equals(comments, location.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, description, comments);
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", description='" + description + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
