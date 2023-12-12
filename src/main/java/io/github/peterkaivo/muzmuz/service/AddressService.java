package io.github.peterkaivo.muzmuz.service;

import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundException;
import io.github.peterkaivo.muzmuz.service.model.Address;

import java.util.List;

/**
 * Service class handling {@link io.github.peterkaivo.muzmuz.service.model.Address}
 */
public interface AddressService {
    public List<Address> getAllAddresses();
    public Address getAddress(Long id) throws DBObjectNotFoundException;
    public Address saveAddress(Address address);
}