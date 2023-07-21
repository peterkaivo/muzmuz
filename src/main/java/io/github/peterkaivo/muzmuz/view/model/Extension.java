package io.github.peterkaivo.muzmuz.view.model;

import java.util.Objects;

/**
 * Parent view class for {@link Item} extension data
 */
public abstract class Extension {
    private Long id;
    private String name;
    private String templateName;
    private String description;
    private String comments;

    public Extension() {
    }

    public Extension(Long id, String name, String templateName, String description, String comments) {
        this.id = id;
        this.name = name;
        this.templateName = templateName;
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

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
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
        Extension extension = (Extension) o;
        return Objects.equals(id, extension.id)
                && Objects.equals(name, extension.name)
                && Objects.equals(templateName, extension.templateName)
                && Objects.equals(description, extension.description)
                && Objects.equals(comments, extension.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, templateName, description, comments);
    }

    @Override
    public String toString() {
        return "Extension{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", templateName='" + templateName + '\'' +
                ", description='" + description + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
