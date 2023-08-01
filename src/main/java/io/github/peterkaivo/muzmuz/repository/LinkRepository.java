package io.github.peterkaivo.muzmuz.repository;

import io.github.peterkaivo.muzmuz.repository.model.DLink;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for {@link DLink} class
 */
public interface LinkRepository extends CrudRepository<DLink, Long> {
}
