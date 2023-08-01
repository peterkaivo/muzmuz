package io.github.peterkaivo.muzmuz.repository;

import io.github.peterkaivo.muzmuz.repository.model.DDimension;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for {@link DDimension} class
 */
public interface DimensionRepository extends CrudRepository<DDimension, Long> {
}
