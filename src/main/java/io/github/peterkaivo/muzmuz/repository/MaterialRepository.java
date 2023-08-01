package io.github.peterkaivo.muzmuz.repository;

import io.github.peterkaivo.muzmuz.repository.model.DMaterial;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for {@link DMaterial} class
 */
public interface MaterialRepository extends CrudRepository<DMaterial, Long> {
}
