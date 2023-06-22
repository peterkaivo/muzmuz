package io.github.peterkaivo.muzmuz.dataservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.List;
import java.util.Objects;

/**
 * View class of {@link DExtension} implementation containing information about strings
 */
@Entity
@Table(name = "STRINGS")
public class DStrings extends DExtension {
    private List<Long> strings;
    private Long schema;

    public DStrings() {
    }

    public DStrings(Long id, String name, String schemaName, String description, String comments,
                    List<Long> strings, Long schema) {
        super(id, name, schemaName, description, comments);
        this.strings = strings;
        this.schema = schema;
    }

    public List<Long> getStrings() {
        return strings;
    }

    public void setStrings(List<Long> strings) {
        this.strings = strings;
    }

    public Long getSchema() {
        return schema;
    }

    public void setSchema(Long schema) {
        this.schema = schema;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DStrings dStrings = (DStrings) o;
        return Objects.equals(strings, dStrings.strings)
                && Objects.equals(schema, dStrings.schema);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), strings, schema);
    }

    @Override
    public String toString() {
        return "DStrings{" +
                "strings=" + strings +
                ", schema=" + schema +
                "} " + super.toString();
    }
}
