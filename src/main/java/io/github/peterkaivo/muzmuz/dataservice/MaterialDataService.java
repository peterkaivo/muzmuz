package io.github.peterkaivo.muzmuz.dataservice;

import io.github.peterkaivo.muzmuz.dataservice.model.DMaterial;
import org.springframework.data.repository.CrudRepository;

/**
 * Data service interface for {@link DMaterial} class
 */
public interface MaterialDataService extends CrudRepository<DMaterial, Long> {
}
