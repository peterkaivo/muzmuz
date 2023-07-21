package io.github.peterkaivo.muzmuz.dataservice;

import io.github.peterkaivo.muzmuz.dataservice.model.DAudio;
import org.springframework.data.repository.CrudRepository;

/**
 * Data service interface for {@link DAudio} class
 */
public interface AudioDataService extends CrudRepository<DAudio, Long> {
}
