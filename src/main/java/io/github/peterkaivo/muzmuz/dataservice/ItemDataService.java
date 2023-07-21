package io.github.peterkaivo.muzmuz.dataservice;

import io.github.peterkaivo.muzmuz.dataservice.model.DItem;
import org.springframework.data.repository.CrudRepository;

/**
 * Data service interface for {@link DItem} class
 */
public interface ItemDataService extends CrudRepository<DItem, Long> {
}
