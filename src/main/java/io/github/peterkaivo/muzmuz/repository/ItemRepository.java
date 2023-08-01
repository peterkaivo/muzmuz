package io.github.peterkaivo.muzmuz.repository;

import io.github.peterkaivo.muzmuz.repository.model.DItem;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for {@link DItem} class
 */
public interface ItemRepository extends CrudRepository<DItem, Long> {
}
