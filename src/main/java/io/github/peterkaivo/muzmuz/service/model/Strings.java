package io.github.peterkaivo.muzmuz.service.model;

import java.util.List;
import java.util.Objects;

/**
 * View class of {@link Extension} impl containing information about strings
 */
public class Strings extends Extension {
    private List<StringInfo> strings;
    private Drawing schema;

    public Strings() {
    }

    public Strings(Long id, String name, String templateName, String description, String comments,
                   List<StringInfo> strings, Drawing schema) {
        super(id, name, templateName, description, comments);
        this.strings = strings;
        this.schema = schema;
    }

    public List<StringInfo> getStrings() {
        return strings;
    }

    public void setStrings(List<StringInfo> strings) {
        this.strings = strings;
    }

    public Drawing getSchema() {
        return schema;
    }

    public void setSchema(Drawing schema) {
        this.schema = schema;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Strings strings1 = (Strings) o;
        return Objects.equals(strings, strings1.strings)
                && Objects.equals(schema, strings1.schema);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), strings, schema);
    }

    @Override
    public String toString() {
        return "Strings{" +
                "strings=" + strings +
                ", schema=" + schema +
                "} " + super.toString();
    }
}
