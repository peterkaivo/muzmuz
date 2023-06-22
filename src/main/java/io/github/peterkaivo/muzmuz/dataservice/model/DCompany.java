package io.github.peterkaivo.muzmuz.dataservice.model;

import io.github.peterkaivo.muzmuz.common.types.SubjectType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

/**
 * Data class describing a legal subject
 */
@Entity
@DiscriminatorValue("Company")
public class DCompany extends DSubject {
    private String Name;
    @Temporal(TemporalType.DATE)
    private Date founded;

    public DCompany() {
    }

    public DCompany(Long id, Long address, Long defaultPhoto, Long defaultGallery, Set<Long> galleries,
                    Set<Long> audio, Set<Long> video, Set<Long> files, Set<Long> links, String description,
                    String comments, String name, Date founded) {
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

    public Date getFounded() {
        return founded;
    }

    public void setFounded(Date founded) {
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
