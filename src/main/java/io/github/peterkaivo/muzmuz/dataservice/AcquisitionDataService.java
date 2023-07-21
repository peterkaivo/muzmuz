package io.github.peterkaivo.muzmuz.dataservice;

import io.github.peterkaivo.muzmuz.dataservice.model.DAcquisition;
import org.springframework.data.repository.CrudRepository;

/**
 * Data service interface for {@link DAcquisition} class
 */
public interface AcquisitionDataService extends CrudRepository<DAcquisition, Long> {
}
