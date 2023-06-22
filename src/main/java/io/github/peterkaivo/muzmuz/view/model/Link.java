package io.github.peterkaivo.muzmuz.view.model;

import io.github.peterkaivo.muzmuz.common.types.MediaType;

import java.util.Objects;

/**
 * View class for media content located on the Internet
 */
public class Link extends Medium {
    private String url;

    public Link() {
    }

    public Link(Long id, String name, String fileName, String description, String comments, String url) {
        super(id, MediaType.LINK, name, fileName, description, comments);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Link link = (Link) o;
        return Objects.equals(url, link.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), url);
    }

    @Override
    public String toString() {
        return "Link{" +
                "url='" + url + '\'' +
                "} " + super.toString();
    }
}
