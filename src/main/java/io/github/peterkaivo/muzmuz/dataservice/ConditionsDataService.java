package io.github.peterkaivo.muzmuz.dataservice;

import io.github.peterkaivo.muzmuz.dataservice.model.DConditions;
import org.springframework.data.repository.CrudRepository;

/**
 * Data service interface for {@link DConditions} class
 */
public interface ConditionsDataService extends CrudRepository<DConditions, Long> {
}
