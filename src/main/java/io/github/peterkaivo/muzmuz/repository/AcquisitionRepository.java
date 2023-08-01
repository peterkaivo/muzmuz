package io.github.peterkaivo.muzmuz.repository;

import io.github.peterkaivo.muzmuz.repository.model.DAcquisition;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for {@link DAcquisition} class
 */
public interface AcquisitionRepository extends CrudRepository<DAcquisition, Long> {
}
