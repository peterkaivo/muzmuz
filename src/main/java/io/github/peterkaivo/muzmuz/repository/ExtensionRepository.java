package io.github.peterkaivo.muzmuz.repository;

import io.github.peterkaivo.muzmuz.repository.model.DExtension;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for {@link DExtension} class
 */
public interface ExtensionRepository extends CrudRepository<DExtension, Long> {
}
