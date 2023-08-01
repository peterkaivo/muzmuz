package io.github.peterkaivo.muzmuz.service;

import io.github.peterkaivo.muzmuz.common.exceptions.ItemNotFoundException;
import io.github.peterkaivo.muzmuz.service.model.Acquisition;

import java.util.List;

/**
 * Service class handling {@link io.github.peterkaivo.muzmuz.service.model.Acquisition}
 */
public interface AcquisitionService {
    public List<Acquisition> getAllAcquisitions();
    public Acquisition getAcquisition(Long id) throws ItemNotFoundException;
    public Acquisition saveAcquisition(Acquisition acquisition);
}
