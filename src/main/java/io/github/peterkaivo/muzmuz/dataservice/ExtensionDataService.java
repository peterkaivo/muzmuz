package io.github.peterkaivo.muzmuz.dataservice;

import io.github.peterkaivo.muzmuz.dataservice.model.DExtension;
import org.springframework.data.repository.CrudRepository;

/**
 * Data service interface for {@link DExtension} class
 */
public interface ExtensionDataService extends CrudRepository<DExtension, Long> {
}
