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
 * Data class describing a physical subject
 */
@Entity
@DiscriminatorValue("Person")
public class DPerson extends DSubject {
    String firstName;
    String middleName;
    String lastName;
    @Temporal(TemporalType.DATE)
    Date birth;

    public DPerson() {
    }

    public DPerson(Long id, Long address, Long defaultPhoto, Long defaultGallery, Set<Long> galleries,
                   Set<Long> audio, Set<Long> video, Set<Long> files, Set<Long> links, String description,
                   String comments, String firstName, String middleName, String lastName, Date birth) {
        super(id, SubjectType.PERSON, address, defaultPhoto, defaultGallery, galleries, audio, video, files, links,
                description, comments);
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birth = birth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DPerson dPerson = (DPerson) o;
        return Objects.equals(firstName, dPerson.firstName)
                && Objects.equals(middleName, dPerson.middleName)
                && Objects.equals(lastName, dPerson.lastName)
                && Objects.equals(birth, dPerson.birth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstName, middleName, lastName, birth);
    }

    @Override
    public String toString() {
        return "DPerson{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birth=" + birth +
                "} " + super.toString();
    }
}
