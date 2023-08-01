package io.github.peterkaivo.muzmuz.repository;

import io.github.peterkaivo.muzmuz.repository.model.DAddress;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for {@link DAddress} class
 */
public interface AddressRepository extends CrudRepository<DAddress, Long> {
}
