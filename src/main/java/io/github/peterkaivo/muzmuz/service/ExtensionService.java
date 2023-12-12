package io.github.peterkaivo.muzmuz.service;

import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundException;
import io.github.peterkaivo.muzmuz.service.model.Extension;

import java.util.List;
import java.util.Set;

/**
 * Service class handling {@link io.github.peterkaivo.muzmuz.service.model.Extension}
 */
public interface ExtensionService {
    public List<Extension> getAllExtensions();
    public Extension getExtension(Long id) throws DBObjectNotFoundException;
    public Set<Extension> getExtensions(Set<Long> ids);
    public Extension saveExtension(Extension extension);
}
