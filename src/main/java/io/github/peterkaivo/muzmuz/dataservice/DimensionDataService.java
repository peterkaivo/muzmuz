package io.github.peterkaivo.muzmuz.dataservice;

import io.github.peterkaivo.muzmuz.dataservice.model.DDimension;
import org.springframework.data.repository.CrudRepository;

/**
 * Data service interface for {@link DDimension} class
 */
public interface DimensionDataService extends CrudRepository<DDimension, Long> {
}
