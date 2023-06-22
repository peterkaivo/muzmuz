package io.github.peterkaivo.muzmuz.dataservice.model;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * Parent data class for {@link DItem} extension data
 */
@MappedSuperclass
public abstract class DExtension {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String schemaName;
    @Lob
    private String description;
    @Lob
    private String comments;

    public DExtension() {
    }

    public DExtension(Long id, String name, String schemaName, String description, String comments) {
        this.id = id;
        this.name = name;
        this.schemaName = schemaName;
        this.description = description;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
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
        DExtension dExtension = (DExtension) o;
        return Objects.equals(id, dExtension.id)
                && Objects.equals(name, dExtension.name)
                && Objects.equals(schemaName, dExtension.schemaName)
                && Objects.equals(description, dExtension.description)
                && Objects.equals(comments, dExtension.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, schemaName, description, comments);
    }

    @Override
    public String toString() {
        return "DExtension{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", schemaName='" + schemaName + '\'' +
                ", description='" + description + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
