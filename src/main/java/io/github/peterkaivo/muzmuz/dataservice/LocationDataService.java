package io.github.peterkaivo.muzmuz.dataservice;

import io.github.peterkaivo.muzmuz.dataservice.model.DLocation;
import org.springframework.data.repository.CrudRepository;

/**
 * Data service interface for {@link DLocation} class
 */
public interface LocationDataService extends CrudRepository<DLocation, Long> {
}
