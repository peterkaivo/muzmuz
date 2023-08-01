package io.github.peterkaivo.muzmuz.repository;

import io.github.peterkaivo.muzmuz.repository.model.DFile;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for {@link DFile} class
 */
public interface FileRepository extends CrudRepository<DFile, Long> {
}
