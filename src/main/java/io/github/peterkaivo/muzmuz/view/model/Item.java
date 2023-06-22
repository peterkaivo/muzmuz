package io.github.peterkaivo.muzmuz.view.model;

import io.github.peterkaivo.muzmuz.common.types.ItemStatus;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

/**
 * View class containing info about registered item
 */
public class Item {
    private Long id;
    private String inventoryNumber;
    private String name;
    private String additionalName;
    private String category;
    private Photo defaultPhoto;
    private ItemStatus status;
    private String description;
    private Set<String> labels;
    private Set<Drawing> drawings;
    private Set<Dimension> dimensions;
    private Set<Material> material;
    private Location location;
    private Subject owner;
    private Conditions currentConditions;
    private String comments;
    private Date manufactureDate;
    private Set<Subject> manufacturers;
    private Acquisition acquisition;
    private Conditions acquisitionCondition;
    private ImageGallery defaultGallery;
    private Set<ImageGallery> galleries;
    private Set<Audio> audio;
    private Set<Video> video;
    private Set<File> files;
    private Set<Link> links;
    private Set<Extension> extensions;
    private Set<Accessory> accessories;

    public Item() {
    }

    public Item(Long id, String inventoryNumber, String name, String additionalName, String category,
                Photo defaultPhoto, ItemStatus status, String description, Set<String> labels, Set<Drawing> drawings,
                Set<Dimension> dimensions, Set<Material> material, Location location, Subject owner,
                Conditions currentConditions, String comments, Date manufactureDate, Set<Subject> manufacturers,
                Acquisition acquisition, Conditions acquisitionCondition, ImageGallery defaultGallery,
                Set<ImageGallery> galleries, Set<Audio> audio, Set<Video> video, Set<File> files, Set<Link> links,
                Set<Extension> extensions, Set<Accessory> accessories) {
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

    public Photo getDefaultPhoto() {
        return defaultPhoto;
    }

    public void setDefaultPhoto(Photo defaultPhoto) {
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

    public Set<Drawing> getDrawings() {
        return drawings;
    }

    public void setDrawings(Set<Drawing> drawings) {
        this.drawings = drawings;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Subject getOwner() {
        return owner;
    }

    public void setOwner(Subject owner) {
        this.owner = owner;
    }

    public Conditions getCurrentConditions() {
        return currentConditions;
    }

    public void setCurrentConditions(Conditions currentConditions) {
        this.currentConditions = currentConditions;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public Set<Subject> getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(Set<Subject> manufacturers) {
        this.manufacturers = manufacturers;
    }

    public Acquisition getAcquisition() {
        return acquisition;
    }

    public void setAcquisition(Acquisition acquisition) {
        this.acquisition = acquisition;
    }

    public Conditions getAcquisitionCondition() {
        return acquisitionCondition;
    }

    public void setAcquisitionCondition(Conditions acquisitionCondition) {
        this.acquisitionCondition = acquisitionCondition;
    }

    public ImageGallery getDefaultGallery() {
        return defaultGallery;
    }

    public void setDefaultGallery(ImageGallery defaultGallery) {
        this.defaultGallery = defaultGallery;
    }

    public Set<ImageGallery> getGalleries() {
        return galleries;
    }

    public void setGalleries(Set<ImageGallery> galleries) {
        this.galleries = galleries;
    }

    public Set<Audio> getAudio() {
        return audio;
    }

    public void setAudio(Set<Audio> audio) {
        this.audio = audio;
    }

    public Set<Video> getVideo() {
        return video;
    }

    public void setVideo(Set<Video> video) {
        this.video = video;
    }

    public Set<File> getFiles() {
        return files;
    }

    public void setFiles(Set<File> files) {
        this.files = files;
    }

    public Set<Link> getLinks() {
        return links;
    }

    public void setLinks(Set<Link> links) {
        this.links = links;
    }

    public Set<Extension> getExtensions() {
        return extensions;
    }

    public void setExtensions(Set<Extension> extensions) {
        this.extensions = extensions;
    }

    public Set<Accessory> getAccessories() {
        return accessories;
    }

    public void setAccessories(Set<Accessory> accessories) {
        this.accessories = accessories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
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
}
