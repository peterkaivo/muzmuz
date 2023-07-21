package io.github.peterkaivo.muzmuz.dataservice;

import io.github.peterkaivo.muzmuz.dataservice.model.DStringInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * Data service interface for {@link DStringInfo} class
 */
public interface StringInfoDataService extends CrudRepository<DStringInfo, Long> {
}
