package io.github.peterkaivo.muzmuz.service;

import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundException;
import io.github.peterkaivo.muzmuz.service.model.Link;

import java.util.List;
import java.util.Set;

/**
 * Service class handling {@link io.github.peterkaivo.muzmuz.service.model.Link}
 */
public interface LinkService {
    public List<Link> getAllLinks();
    public Link getLink(Long id) throws DBObjectNotFoundException;
    public Set<Link> getLinkSet(Set<Long> ids);
    public Link saveLink(Link link);
}
