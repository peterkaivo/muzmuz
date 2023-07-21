package io.github.peterkaivo.muzmuz.dataservice;

import io.github.peterkaivo.muzmuz.dataservice.model.DAccessory;
import org.springframework.data.repository.CrudRepository;

/**
 * Data service interface for {@link DAccessory} class
 */
public interface AccessoryDataService extends CrudRepository<DAccessory, Long> {
}
