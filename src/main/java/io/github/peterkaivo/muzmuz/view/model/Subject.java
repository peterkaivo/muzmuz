package io.github.peterkaivo.muzmuz.view.model;

import io.github.peterkaivo.muzmuz.common.types.SubjectType;

import java.util.Objects;
import java.util.Set;

/**
 * Parent view class representing common information and data of physical or legal subject
 */
public abstract class Subject {
    private Long id;
    private SubjectType subjectType;
    private Address address;
    private Photo defaultPhoto;
    private ImageGallery defaultGallery;
    private Set<ImageGallery> galleries;
    private Set<Audio> audio;
    private Set<Video> video;
    private Set<File> files;
    private Set<Link> links;
    private String description;
    private String comments;

    public Subject() {
    }

    public Subject(Long id, SubjectType subjectType, Address address, Photo defaultPhoto, ImageGallery defaultGallery,
                   Set<ImageGallery> galleries, Set<Audio> audio, Set<Video> video, Set<File> files, Set<Link> links,
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
        Subject subject = (Subject) o;
        return Objects.equals(id, subject.id)
                && subjectType == subject.subjectType
                && Objects.equals(address, subject.address)
                && Objects.equals(defaultPhoto, subject.defaultPhoto)
                && Objects.equals(defaultGallery, subject.defaultGallery)
                && Objects.equals(galleries, subject.galleries)
                && Objects.equals(audio, subject.audio)
                && Objects.equals(video, subject.video)
                && Objects.equals(files, subject.files)
                && Objects.equals(links, subject.links)
                && Objects.equals(description, subject.description)
                && Objects.equals(comments, subject.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subjectType, address, defaultPhoto, defaultGallery, galleries, audio, video, files,
                links, description, comments);
    }

    @Override
    public String toString() {
        return "Subject{" +
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
