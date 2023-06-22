package io.github.peterkaivo.muzmuz.dataservice.model;

import io.github.peterkaivo.muzmuz.common.types.ItemStatus;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

/**
 * Data class containing info about an accessory of item
 */
@Entity
@Table(name = "ACCESSORY")
public class DAccessory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String inventoryNumber;
    private String name;
    private String additionalName;
    private Long defaultPhoto;
    private Long defaultGallery;
    @Enumerated(EnumType.STRING)
    private ItemStatus status;
    private Long location;
    private Set<Long> dimensions;
    private Set<Long> material;
    @Lob
    private String description;
    @Lob
    private String comments;

    public DAccessory() {
    }

    public DAccessory(Long id, String inventoryNumber, String name, String additionalName, Long defaultPhoto,
                      Long defaultGallery, ItemStatus status, Long location, Set<Long> dimensions,
                      Set<Long> material, String description, String comments) {
        this.id = id;
        this.inventoryNumber = inventoryNumber;
        this.name = name;
        this.additionalName = additionalName;
        this.defaultPhoto = defaultPhoto;
        this.defaultGallery = defaultGallery;
        this.status = status;
        this.location = location;
        this.dimensions = dimensions;
        this.material = material;
        this.description = description;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(String inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdditionalName() {
        return additionalName;
    }

    public void setAdditionalName(String additionalName) {
        this.additionalName = additionalName;
    }

    public Long getDefaultPhoto() {
        return defaultPhoto;
    }

    public void setDefaultPhoto(Long defaultPhoto) {
        this.defaultPhoto = defaultPhoto;
    }

    public Long getDefaultGallery() {
        return defaultGallery;
    }

    public void setDefaultGallery(Long defaultGallery) {
        this.defaultGallery = defaultGallery;
    }

    public ItemStatus getStatus() {
        return status;
    }

    public void setStatus(ItemStatus status) {
        this.status = status;
    }

    public Long getLocation() {
        return location;
    }

    public void setLocation(Long location) {
        this.location = location;
    }

    public Set<Long> getDimensions() {
        return dimensions;
    }

    public void setDimensions(Set<Long> dimensions) {
        this.dimensions = dimensions;
    }

    public Set<Long> getMaterial() {
        return material;
    }

    public void setMaterial(Set<Long> material) {
        this.material = material;
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
        DAccessory dAccessory = (DAccessory) o;
        return Objects.equals(id, dAccessory.id)
                && Objects.equals(inventoryNumber, dAccessory.inventoryNumber)
                && Objects.equals(name, dAccessory.name)
                && Objects.equals(additionalName, dAccessory.additionalName)
                && Objects.equals(defaultPhoto, dAccessory.defaultPhoto)
                && Objects.equals(defaultGallery, dAccessory.defaultGallery)
                && status == dAccessory.status && Objects.equals(location, dAccessory.location)
                && Objects.equals(dimensions, dAccessory.dimensions)
                && Objects.equals(material, dAccessory.material)
                && Objects.equals(description, dAccessory.description)
                && Objects.equals(comments, dAccessory.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, inventoryNumber, name, additionalName, defaultPhoto, defaultGallery, status, location,
                dimensions, material, description, comments);
    }

    @Override
    public String toString() {
        return "DAccessory{" +
                "id=" + id +
                ", inventoryNumber='" + inventoryNumber + '\'' +
                ", name='" + name + '\'' +
                ", additionalName='" + additionalName + '\'' +
                ", defaultPhoto=" + defaultPhoto +
                ", defaultGallery=" + defaultGallery +
                ", status=" + status +
                ", location=" + location +
                ", dimensions=" + dimensions +
                ", material=" + material +
                ", description='" + description + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
