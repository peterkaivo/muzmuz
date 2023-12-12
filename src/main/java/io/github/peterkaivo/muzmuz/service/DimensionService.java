package io.github.peterkaivo.muzmuz.service;

import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundException;
import io.github.peterkaivo.muzmuz.service.model.Dimension;

import java.util.List;
import java.util.Set;

/**
 * Service class handling {@link io.github.peterkaivo.muzmuz.service.model.Dimension}
 */
public interface DimensionService {
    public List<Dimension> getAllDimensions();
    public Dimension getDimension(Long id) throws DBObjectNotFoundException;
    public Dimension saveDimension(Dimension dimension);
    public Set<Dimension> getDimensions(Set<Long> ids);
}
