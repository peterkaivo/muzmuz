package io.github.peterkaivo.muzmuz.view.model;

import io.github.peterkaivo.muzmuz.common.types.ItemStatus;

import java.util.Objects;
import java.util.Set;

/**
 * View class containing info about an accessory of item
 */
public class Accessory {
    private Long id;
    private String inventoryNumber;
    private String name;
    private String additionalName;
    private Photo defaultPhoto;
    private ImageGallery defaultGallery;
    private ItemStatus status;
    private Location location;
    private Set<Dimension> dimensions;
    private Set<Material> material;
    private String description;
    private String comments;

    public Accessory() {
    }

    public Accessory(Long id, String inventoryNumber, String name, String additionalName, Photo defaultPhoto,
                     ImageGallery defaultGallery, ItemStatus status, Location location, Set<Dimension> dimensions,
                     Set<Material> material, String description, String comments) {
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

    public Photo getDefaultPhoto() {
        return defaultPhoto;
    }

    public void setDefaultPhoto(Photo defaultPhoto) {
        this.defaultPhoto = defaultPhoto;
    }

    public ImageGallery getDefaultGallery() {
        return defaultGallery;
    }

    public void setDefaultGallery(ImageGallery defaultGallery) {
        this.defaultGallery = defaultGallery;
    }

    public ItemStatus getStatus() {
        return status;
    }

    public void setStatus(ItemStatus status) {
        this.status = status;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Set<Dimension> getDimensions() {
        return dimensions;
    }

    public void setDimensions(Set<Dimension> dimensions) {
        this.dimensions = dimensions;
    }

    public Set<Material> getMaterial() {
        return material;
    }

    public void setMaterial(Set<Material> material) {
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
        Accessory accessory = (Accessory) o;
        return Objects.equals(id, accessory.id)
                && Objects.equals(inventoryNumber, accessory.inventoryNumber)
                && Objects.equals(name, accessory.name)
                && Objects.equals(additionalName, accessory.additionalName)
                && Objects.equals(defaultPhoto, accessory.defaultPhoto)
                && Objects.equals(defaultGallery, accessory.defaultGallery)
                && status == accessory.status && Objects.equals(location, accessory.location)
                && Objects.equals(dimensions, accessory.dimensions)
                && Objects.equals(material, accessory.material)
                && Objects.equals(description, accessory.description)
                && Objects.equals(comments, accessory.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, inventoryNumber, name, additionalName, defaultPhoto, defaultGallery, status, location,
                dimensions, material, description, comments);
    }

    @Override
    public String toString() {
        return "Accessory{" +
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
