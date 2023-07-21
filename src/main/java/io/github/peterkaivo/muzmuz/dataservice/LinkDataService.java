package io.github.peterkaivo.muzmuz.dataservice;

import io.github.peterkaivo.muzmuz.dataservice.model.DLink;
import org.springframework.data.repository.CrudRepository;

/**
 * Data service interface for {@link DLink} class
 */
public interface LinkDataService extends CrudRepository<DLink, Long> {
}
