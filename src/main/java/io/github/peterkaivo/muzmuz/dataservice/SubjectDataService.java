package io.github.peterkaivo.muzmuz.dataservice;

import io.github.peterkaivo.muzmuz.dataservice.model.DSubject;
import org.springframework.data.repository.CrudRepository;

/**
 * Data service interface for {@link DSubject} class
 */
public interface SubjectDataService extends CrudRepository<DSubject, Long> {
}
