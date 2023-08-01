package io.github.peterkaivo.muzmuz.repository.model;

import io.github.peterkaivo.muzmuz.common.types.ItemStatus;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

/**
 * Data class containing info about registered item
 */
@Entity
@Table(name = "ITEM")
public class DItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String inventoryNumber;
    private String name;
    private String additionalName;
    private String category;
    private Long defaultPhoto;
    @Enumerated(EnumType.STRING)
    private ItemStatus status;
    @Lob
    private String description;
    private Set<String> labels;
    private Set<Long> drawings;
    private Set<Long> dimensions;
    private Set<Long> material;
    private Long location;
    private Long owner;
    private Long currentConditions;
    @Lob
    private String comments;
    private String manufactureDate;
    private Set<Long> manufacturers;
    private Long acquisition;
    private Long acquisitionCondition;
    private Long defaultGallery;
    private Set<Long> galleries;
    private Set<Long> audio;
    private Set<Long> video;
    private Set<Long> files;
    private Set<Long> links;
    private Set<Long> extensions;
    private Set<Long> accessories;

    public DItem() {
    }

    public DItem(Long id, String inventoryNumber, String name, String additionalName, String category,
                 Long defaultPhoto, ItemStatus status, String description, Set<String> labels, Set<Long> drawings,
                 Set<Long> dimensions, Set<Long> material, Long location, Long owner,
                 Long currentConditions, String comments, String manufactureDate, Set<Long> manufacturers,
                 Long acquisition, Long acquisitionCondition, Long defaultGallery,
                 Set<Long> galleries, Set<Long> audio, Set<Long> video, Set<Long> files, Set<Long> links,
                 Set<Long> extensions, Set<Long> accessories) {
        this.id = id;
        this.inventoryNumber = inventoryNumber;
        this.name = name;
        this.additionalName = additionalName;
        this.category = category;
        this.defaultPhoto = defaultPhoto;
        this.status = status;
        this.description = description;
        this.labels = labels;
        this.drawings = drawings;
        this.dimensions = dimensions;
        this.material = material;
        this.location = location;
        this.owner = owner;
        this.currentConditions = currentConditions;
        this.comments = comments;
        this.manufactureDate = manufactureDate;
        this.manufacturers = manufacturers;
        this.acquisition = acquisition;
        this.acquisitionCondition = acquisitionCondition;
        this.defaultGallery = defaultGallery;
        this.galleries = galleries;
        this.audio = audio;
        this.video = video;
        this.files = files;
        this.links = links;
        this.extensions = extensions;
        this.accessories = accessories;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getDefaultPhoto() {
        return defaultPhoto;
    }

    public void setDefaultPhoto(Long defaultPhoto) {
        this.defaultPhoto = defaultPhoto;
    }

    public ItemStatus getStatus() {
        return status;
    }

    public void setStatus(ItemStatus status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<String> getLabels() {
        return labels;
    }

    public void setLabels(Set<String> labels) {
        this.labels = labels;
    }

    public Set<Long> getDrawings() {
        return drawings;
    }

    public void setDrawings(Set<Long> drawings) {
        this.drawings = drawings;
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

    public Long getLocation() {
        return location;
    }

    public void setLocation(Long location) {
        this.location = location;
    }

    public Long getOwner() {
        return owner;
    }

    public void setOwner(Long owner) {
        this.owner = owner;
    }

    public Long getCurrentConditions() {
        return currentConditions;
    }

    public void setCurrentConditions(Long currentConditions) {
        this.currentConditions = currentConditions;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public Set<Long> getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(Set<Long> manufacturers) {
        this.manufacturers = manufacturers;
    }

    public Long getAcquisition() {
        return acquisition;
    }

    public void setAcquisition(Long acquisition) {
        this.acquisition = acquisition;
    }

    public Long getAcquisitionCondition() {
        return acquisitionCondition;
    }

    public void setAcquisitionCondition(Long acquisitionCondition) {
        this.acquisitionCondition = acquisitionCondition;
    }

    public Long getDefaultGallery() {
        return defaultGallery;
    }

    public void setDefaultGallery(Long defaultGallery) {
        this.defaultGallery = defaultGallery;
    }

    public Set<Long> getGalleries() {
        return galleries;
    }

    public void setGalleries(Set<Long> galleries) {
        this.galleries = galleries;
    }

    public Set<Long> getAudio() {
        return audio;
    }

    public void setAudio(Set<Long> audio) {
        this.audio = audio;
    }

    public Set<Long> getVideo() {
        return video;
    }

    public void setVideo(Set<Long> video) {
        this.video = video;
    }

    public Set<Long> getFiles() {
        return files;
    }

    public void setFiles(Set<Long> files) {
        this.files = files;
    }

    public Set<Long> getLinks() {
        return links;
    }

    public void setLinks(Set<Long> links) {
        this.links = links;
    }

    public Set<Long> getExtensions() {
        return extensions;
    }

    public void setExtensions(Set<Long> extensions) {
        this.extensions = extensions;
    }

    public Set<Long> getAccessories() {
        return accessories;
    }

    public void setAccessories(Set<Long> accessories) {
        this.accessories = accessories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DItem item = (DItem) o;
        return Objects.equals(id, item.id)
                && Objects.equals(inventoryNumber, item.inventoryNumber)
                && Objects.equals(name, item.name)
                && Objects.equals(additionalName, item.additionalName)
                && Objects.equals(category, item.category)
                && Objects.equals(defaultPhoto, item.defaultPhoto)
                && status == item.status
                && Objects.equals(description, item.description)
                && Objects.equals(labels, item.labels)
                && Objects.equals(drawings, item.drawings)
                && Objects.equals(dimensions, item.dimensions)
                && Objects.equals(material, item.material)
                && Objects.equals(location, item.location)
                && Objects.equals(owner, item.owner)
                && Objects.equals(currentConditions, item.currentConditions)
                && Objects.equals(comments, item.comments)
                && Objects.equals(manufactureDate, item.manufactureDate)
                && Objects.equals(manufacturers, item.manufacturers)
                && Objects.equals(acquisition, item.acquisition)
                && Objects.equals(acquisitionCondition, item.acquisitionCondition)
                && Objects.equals(defaultGallery, item.defaultGallery)
                && Objects.equals(galleries, item.galleries)
                && Objects.equals(audio, item.audio)
                && Objects.equals(video, item.video)
                && Objects.equals(files, item.files)
                && Objects.equals(links, item.links)
                && Objects.equals(extensions, item.extensions)
                && Objects.equals(accessories, item.accessories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, inventoryNumber, name, additionalName, category, defaultPhoto, status, description,
                labels, drawings, dimensions, material, location, owner, currentConditions, comments, manufactureDate,
                manufacturers, acquisition, acquisitionCondition, defaultGallery, galleries, audio, video, files,
                links, extensions, accessories);
    }

    @Override
    public String toString() {
        return "DItem{" +
                "id=" + id +
                ", inventoryNumber='" + inventoryNumber + '\'' +
                ", name='" + name + '\'' +
                ", additionalName='" + additionalName + '\'' +
                ", category='" + category + '\'' +
                ", defaultPhoto=" + defaultPhoto +
                ", status=" + status +
                ", description='" + description + '\'' +
                ", labels=" + labels +
                ", drawings=" + drawings +
                ", dimensions=" + dimensions +
                ", material=" + material +
                ", location=" + location +
                ", owner=" + owner +
                ", currentConditions=" + currentConditions +
                ", comments='" + comments + '\'' +
                ", manufactureDate='" + manufactureDate + '\'' +
                ", manufacturers=" + manufacturers +
                ", acquisition=" + acquisition +
                ", acquisitionCondition=" + acquisitionCondition +
                ", defaultGallery=" + defaultGallery +
                ", galleries=" + galleries +
                ", audio=" + audio +
                ", video=" + video +
                ", files=" + files +
                ", links=" + links +
                ", extensions=" + extensions +
                ", accessories=" + accessories +
                '}';
    }
}
