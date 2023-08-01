package io.github.peterkaivo.muzmuz.repository;

import io.github.peterkaivo.muzmuz.repository.model.DConditions;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for {@link DConditions} class
 */
public interface ConditionsRepository extends CrudRepository<DConditions, Long> {
}
