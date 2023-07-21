package io.github.peterkaivo.muzmuz.view.model;

import io.github.peterkaivo.muzmuz.common.types.SubjectType;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

/**
 * View class describing a physical subject
 */
public class Person extends Subject {
    private String firstName;
    private String middleName;
    private String lastName;
    private String birth;

    public Person() {
    }

    public Person(Long id, Address address, Photo defaultPhoto, ImageGallery defaultGallery,
                  Set<ImageGallery> galleries, Set<Audio> audio, Set<Video> video, Set<File> files, Set<Link> links,
                  String description, String comments, String firstName, String middleName, String lastName,
                  String birth) {
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

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName)
                && Objects.equals(middleName, person.middleName)
                && Objects.equals(lastName, person.lastName)
                && Objects.equals(birth, person.birth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstName, middleName, lastName, birth);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birth=" + birth +
                "} " + super.toString();
    }
}
