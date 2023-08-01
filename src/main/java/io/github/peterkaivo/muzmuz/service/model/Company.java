package io.github.peterkaivo.muzmuz.service.model;

import io.github.peterkaivo.muzmuz.common.types.SubjectType;

import java.util.Objects;
import java.util.Set;

/**
 * View class describing a legal subject
 */
public class Company extends Subject {
    private String Name;
    private String founded;

    public Company() {
    }

    public Company(Long id, Address address, Photo defaultPhoto, ImageGallery defaultGallery,
                   Set<ImageGallery> galleries, Set<Audio> audio, Set<Video> video, Set<File> files, Set<Link> links,
                   String description, String comments, String name, String founded) {
        super(id, SubjectType.COMPANY, address, defaultPhoto, defaultGallery, galleries, audio, video, files, links,
                description, comments);
        Name = name;
        this.founded = founded;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getFounded() {
        return founded;
    }

    public void setFounded(String founded) {
        this.founded = founded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Company company = (Company) o;
        return Objects.equals(Name, company.Name)
                && Objects.equals(founded, company.founded);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Name, founded);
    }

    @Override
    public String toString() {
        return "Company{" +
                "Name='" + Name + '\'' +
                ", founded=" + founded +
                "} " + super.toString();
    }
}
