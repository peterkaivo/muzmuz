package io.github.peterkaivo.muzmuz.dataservice.model;

import io.github.peterkaivo.muzmuz.common.types.SubjectType;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

/**
 * Parent data class representing common information and data of physical or legal subject
 */
@Entity
@Table(name = "SUBJECT")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type_Discriminator")
public class DSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private SubjectType subjectType;
    private Long address;
    private Long defaultPhoto;
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

    public DSubject() {
    }

    public DSubject(Long id, SubjectType subjectType, Long address, Long defaultPhoto, Long defaultGallery,
                    Set<Long> galleries, Set<Long> audio, Set<Long> video, Set<Long> files, Set<Long> links,
                    String description, String comments) {
        this.id = id;
        this.subjectType = subjectType;
        this.address = address;
        this.defaultPhoto = defaultPhoto;
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

    public SubjectType getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(SubjectType subjectType) {
        this.subjectType = subjectType;
    }

    public Long getAddress() {
        return address;
    }

    public void setAddress(Long address) {
        this.address = address;
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
        DSubject dSubject = (DSubject) o;
        return Objects.equals(id, dSubject.id)
                && subjectType == dSubject.subjectType
                && Objects.equals(address, dSubject.address)
                && Objects.equals(defaultPhoto, dSubject.defaultPhoto)
                && Objects.equals(defaultGallery, dSubject.defaultGallery)
                && Objects.equals(galleries, dSubject.galleries)
                && Objects.equals(audio, dSubject.audio)
                && Objects.equals(video, dSubject.video)
                && Objects.equals(files, dSubject.files)
                && Objects.equals(links, dSubject.links)
                && Objects.equals(description, dSubject.description)
                && Objects.equals(comments, dSubject.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subjectType, address, defaultPhoto, defaultGallery, galleries, audio, video, files,
                links, description, comments);
    }

    @Override
    public String toString() {
        return "DSubject{" +
                "id=" + id +
                ", subjectType=" + subjectType +
                ", address=" + address +
                ", defaultPhoto=" + defaultPhoto +
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
