package io.github.peterkaivo.muzmuz.dataservice.model;

import io.github.peterkaivo.muzmuz.common.types.AcquisitionType;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

/**
 * Data class containing information about acquisition
 */
@Entity
@Table(name = "ACQUISITION")
public class DAcquisition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private AcquisitionType acquisitionType;
    private String acquisitionDate;
    private Long acquiredFrom;
    private Set<Long> acquiredItems;
    private Long defaultGallery;
    private Set<Long> galleries;
    private Set<Long> audio;
    private Set<Long> video;
    private Set<Long> files;
    private Set<Long> links;
    @Lob
    private String description;
    @Lob
    private String comments;

    public DAcquisition() {
    }

    public DAcquisition(Long id, AcquisitionType acquisitionType, String acquisitionDate, Long acquiredFrom,
                        Set<Long> acquiredItems, Long defaultGallery, Set<Long> galleries, Set<Long> audio,
                        Set<Long> video, Set<Long> files, Set<Long> links, String description, String comments) {
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

    public Long getAcquiredFrom() {
        return acquiredFrom;
    }

    public void setAcquiredFrom(Long acquiredFrom) {
        this.acquiredFrom = acquiredFrom;
    }

    public Set<Long> getAcquiredItems() {
        return acquiredItems;
    }

    public void setAcquiredItems(Set<Long> acquiredItems) {
        this.acquiredItems = acquiredItems;
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
        DAcquisition dAcquisition = (DAcquisition) o;
        return Objects.equals(id, dAcquisition.id)
                && acquisitionType == dAcquisition.acquisitionType
                && Objects.equals(acquisitionDate, dAcquisition.acquisitionDate)
                && Objects.equals(acquiredFrom, dAcquisition.acquiredFrom)
                && Objects.equals(acquiredItems, dAcquisition.acquiredItems)
                && Objects.equals(defaultGallery, dAcquisition.defaultGallery)
                && Objects.equals(galleries, dAcquisition.galleries)
                && Objects.equals(audio, dAcquisition.audio)
                && Objects.equals(video, dAcquisition.video)
                && Objects.equals(files, dAcquisition.files)
                && Objects.equals(links, dAcquisition.links)
                && Objects.equals(description, dAcquisition.description)
                && Objects.equals(comments, dAcquisition.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, acquisitionType, acquisitionDate, acquiredFrom, acquiredItems, defaultGallery,
                galleries, audio, video, files, links, description, comments);
    }

    @Override
    public String toString() {
        return "DAcquisition{" +
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
