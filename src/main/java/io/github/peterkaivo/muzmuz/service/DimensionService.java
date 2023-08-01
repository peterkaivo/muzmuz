package io.github.peterkaivo.muzmuz.service;

import io.github.peterkaivo.muzmuz.common.exceptions.ItemNotFoundException;
import io.github.peterkaivo.muzmuz.service.model.Dimension;

import java.util.List;

/**
 * Service class handling {@link io.github.peterkaivo.muzmuz.service.model.Dimension}
 */
public interface DimensionService {
    public List<Dimension> getAllDimensions();
    public Dimension getDimension(Long id) throws ItemNotFoundException;
    public Dimension saveDimension(Dimension acquisition);
}
