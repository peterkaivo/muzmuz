package io.github.peterkaivo.muzmuz.repository;

import io.github.peterkaivo.muzmuz.repository.model.DAccessory;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for {@link DAccessory} class
 */
public interface AccessoryRepository extends CrudRepository<DAccessory, Long> {
}
