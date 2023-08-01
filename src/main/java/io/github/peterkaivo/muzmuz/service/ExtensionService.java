package io.github.peterkaivo.muzmuz.service;

import io.github.peterkaivo.muzmuz.common.exceptions.ItemNotFoundException;
import io.github.peterkaivo.muzmuz.service.model.Extension;

import java.util.List;

/**
 * Service class handling {@link io.github.peterkaivo.muzmuz.service.model.Extension}
 */
public interface ExtensionService {
    public List<Extension> getAllExtensions();
    public Extension getExtension(Long id) throws ItemNotFoundException;
    public Extension saveExtension(Extension acquisition);
}
