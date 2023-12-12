package io.github.peterkaivo.muzmuz.service;

import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundException;
import io.github.peterkaivo.muzmuz.service.model.Acquisition;

import java.util.List;
import java.util.Set;

/**
 * Service class handling {@link io.github.peterkaivo.muzmuz.service.model.Acquisition}
 */
public interface AcquisitionService {
    public List<Acquisition> getAllAcquisitions();
    public Acquisition getAcquisition(Long id) throws DBObjectNotFoundException;
    public Acquisition saveAcquisition(Acquisition acquisition);

    /**
     * Function returns {@link Acquisition} object only with following values populated if not null:
     * - Id
     * - AcquisitionType
     * - AcquisitionDate
     * - AcquiredFrom
     *
     * @param id An ID of the {@link Acquisition} object
     * @return {@link Acquisition} object populated only with values described above or null
     * @throws DBObjectNotFoundException
     */
    public Acquisition getAcquisitionTruncated(Long id) throws DBObjectNotFoundException;
    public Set<Acquisition> getAcquisitionsTruncated(Set<Long> ids);
}
