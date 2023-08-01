package io.github.peterkaivo.muzmuz.service;

import io.github.peterkaivo.muzmuz.common.exceptions.ItemNotFoundException;
import io.github.peterkaivo.muzmuz.service.model.Link;

import java.util.List;

/**
 * Service class handling {@link io.github.peterkaivo.muzmuz.service.model.Link}
 */
public interface LinkService {
    public List<Link> getAllLinks();
    public Link getLink(Long id) throws ItemNotFoundException;
    public Link saveLink(Link acquisition);
}
