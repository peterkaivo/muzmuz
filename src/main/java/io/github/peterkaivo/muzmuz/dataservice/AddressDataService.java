package io.github.peterkaivo.muzmuz.dataservice;

import io.github.peterkaivo.muzmuz.dataservice.model.DAddress;
import org.springframework.data.repository.CrudRepository;

/**
 * Data service interface for {@link DAddress} class
 */
public interface AddressDataService extends CrudRepository<DAddress, Long> {
}
