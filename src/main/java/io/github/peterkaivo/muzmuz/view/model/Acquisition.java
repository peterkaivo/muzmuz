package io.github.peterkaivo.muzmuz.view.model;

import io.github.peterkaivo.muzmuz.common.types.AcquisitionType;

import java.util.Objects;
import java.util.Set;

/**
 * View class containing information about acquisition
 */
public class Acquisition {
    private Long id;
    private AcquisitionType acquisitionType;
    private String acquisitionDate;
    private Subject acquiredFrom;
    private Set<Item> acquiredItems;
    private ImageGallery defaultGallery;
    private Set<ImageGallery> galleries;
    private Set<Audio> audio;
    private Set<Video> video;
    private Set<File> files;
    private Set<Link> links;
    private String description;
    private String comments;

    public Acquisition() {
    }

    public Acquisition(Long id, AcquisitionType acquisitionType, String acquisitionDate, Subject acquiredFrom,
                       Set<Item> acquiredItems, ImageGallery defaultGallery, Set<ImageGallery> galleries,
                       Set<Audio> audio, Set<Video> video, Set<File> files, Set<Link> links, String description,
                       String comments) {
        this.id = id;
        this.acquisitionType = acquisitionType;
        this.acquisitionDate = acquisitionDate;
        this.acquiredFrom = acquiredFrom;
        this.acquiredItems = acquiredItems;
        this.defaultGallery = defaultGallery;
        this.galleries = galleries;
        this.audio = audio;
        this.video = video;
        this.files = files;
        this.links = links;
        this.description = description;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AcquisitionType getAcquisitionType() {
        return acquisitionType;
    }

    public void setAcquisitionType(AcquisitionType acquisitionType) {
        this.acquisitionType = acquisitionType;
    }

    public String getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(String acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public Subject getAcquiredFrom() {
        return acquiredFrom;
    }

    public void setAcquiredFrom(Subject acquiredFrom) {
        this.acquiredFrom = acquiredFrom;
    }

    public Set<Item> getAcquiredItems() {
        return acquiredItems;
    }

    public void setAcquiredItems(Set<Item> acquiredItems) {
        this.acquiredItems = acquiredItems;
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
        Acquisition that = (Acquisition) o;
        return Objects.equals(id, that.id)
                && acquisitionType == that.acquisitionType
                && Objects.equals(acquisitionDate, that.acquisitionDate)
                && Objects.equals(acquiredFrom, that.acquiredFrom)
                && Objects.equals(acquiredItems, that.acquiredItems)
                && Objects.equals(defaultGallery, that.defaultGallery)
                && Objects.equals(galleries, that.galleries)
                && Objects.equals(audio, that.audio)
                && Objects.equals(video, that.video)
                && Objects.equals(files, that.files)
                && Objects.equals(links, that.links)
                && Objects.equals(description, that.description)
                && Objects.equals(comments, that.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, acquisitionType, acquisitionDate, acquiredFrom, acquiredItems, defaultGallery,
                galleries, audio, video, files, links, description, comments);
    }

    @Override
    public String toString() {
        return "Acquisition{" +
                "id=" + id +
                ", acquisitionType=" + acquisitionType +
                ", acquisitionDate=" + acquisitionDate +
                ", acquiredFrom=" + acquiredFrom +
                ", acquiredItems=" + acquiredItems +
                ", defaultGallery=" + defaultGallery +
                ", galleries=" + galleries +
                ", audio=" + audio +
                ", video=" + video +
                ", files=" + files +
                ", links=" + links +
                ", description='" + description + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
