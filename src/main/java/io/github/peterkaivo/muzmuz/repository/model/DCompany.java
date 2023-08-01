package io.github.peterkaivo.muzmuz.repository.model;

import io.github.peterkaivo.muzmuz.common.types.SubjectType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Objects;
import java.util.Set;

/**
 * Data class describing a legal subject
 */
@Entity
@DiscriminatorValue("Company")
public class DCompany extends DSubject {
    private String Name;
    private String founded;

    public DCompany() {
    }

    public DCompany(Long id, Long address, Long defaultPhoto, Long defaultGallery, Set<Long> galleries,
                    Set<Long> audio, Set<Long> video, Set<Long> files, Set<Long> links, String description,
                    String comments, String name, String founded) {
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
        DCompany company = (DCompany) o;
        return Objects.equals(Name, company.Name)
                && Objects.equals(founded, company.founded);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Name, founded);
    }

    @Override
    public String toString() {
        return "DCompany{" +
                "Name='" + Name + '\'' +
                ", founded=" + founded +
                "} " + super.toString();
    }
}
