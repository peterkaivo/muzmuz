package io.github.peterkaivo.muzmuz.repository;

import io.github.peterkaivo.muzmuz.repository.model.DLocation;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for {@link DLocation} class
 */
public interface LocationRepository extends CrudRepository<DLocation, Long> {
}
