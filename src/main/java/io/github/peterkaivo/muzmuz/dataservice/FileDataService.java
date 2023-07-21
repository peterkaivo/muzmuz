package io.github.peterkaivo.muzmuz.dataservice;

import io.github.peterkaivo.muzmuz.dataservice.model.DFile;
import org.springframework.data.repository.CrudRepository;

/**
 * Data service interface for {@link DFile} class
 */
public interface FileDataService extends CrudRepository<DFile, Long> {
}
