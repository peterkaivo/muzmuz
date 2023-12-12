package io.github.peterkaivo.muzmuz.common.exceptions;

import java.util.Objects;

public class DBObjectNotFoundException extends Exception {
    Class<?> affectedClass;
    Long id;

    public DBObjectNotFoundException(Class<?> affectedClass, Long id) {
        super("Object of class = " + affectedClass.getSimpleName() + " with ID = " + id.toString() + " not found in DB");
        this.affectedClass = affectedClass;
        this.id = id;
    }

    public Class<?> getAffectedClass() {
        return affectedClass;
    }

    public void setAffectedClass(Class<?> affectedClass) {
        this.affectedClass = affectedClass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DBObjectNotFoundException that = (DBObjectNotFoundException) o;
        return Objects.equals(affectedClass, that.affectedClass)
                && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(affectedClass, id);
    }

    @Override
    public String toString() {
        return "DBObjectNotFoundException{" +
                "affectedClass=" + affectedClass +
                ", id=" + id +
                "} " + super.toString();
    }
}
