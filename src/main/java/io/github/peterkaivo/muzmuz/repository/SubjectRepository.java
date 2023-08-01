package io.github.peterkaivo.muzmuz.repository;

import io.github.peterkaivo.muzmuz.repository.model.DSubject;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for {@link DSubject} class
 */
public interface SubjectRepository extends CrudRepository<DSubject, Long> {
}
