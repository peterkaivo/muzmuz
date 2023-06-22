package io.github.peterkaivo.muzmuz.dataservice.model;

import io.github.peterkaivo.muzmuz.common.types.MediaType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

/**
 * Data class for media content located on the Internet
 */
@Entity
@Table(name = "LINK")
public class DLink extends DMedium {
    private String url;

    public DLink() {
    }

    public DLink(Long id, String name, String fileName, String description, String comments, String url) {
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
        DLink dLink = (DLink) o;
        return Objects.equals(url, dLink.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), url);
    }

    @Override
    public String toString() {
        return "DLink{" +
                "url='" + url + '\'' +
                "} " + super.toString();
    }
}
