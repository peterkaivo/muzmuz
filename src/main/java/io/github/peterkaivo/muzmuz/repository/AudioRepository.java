package io.github.peterkaivo.muzmuz.repository;

import io.github.peterkaivo.muzmuz.repository.model.DAudio;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for {@link DAudio} class
 */
public interface AudioRepository extends CrudRepository<DAudio, Long> {
}
