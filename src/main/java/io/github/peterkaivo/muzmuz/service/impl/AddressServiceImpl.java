package io.github.peterkaivo.muzmuz.service.impl;

import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundException;
import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundExceptionSupplier;
import io.github.peterkaivo.muzmuz.repository.AddressRepository;
import io.github.peterkaivo.muzmuz.repository.model.DAddress;
import io.github.peterkaivo.muzmuz.service.AddressService;
import io.github.peterkaivo.muzmuz.service.model.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AddressService.class);

    @Autowired
    private AddressRepository addressRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Address> getAllAddresses() {
        List<DAddress> addresses = (List<DAddress>) addressRepository.findAll();
        return addresses.stream().map(this::fromDAddress).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Address getAddress(Long id) throws DBObjectNotFoundException {
        DAddress dAddress = addressRepository.findById(id).orElseThrow(new DBObjectNotFoundExceptionSupplier(DAddress.class, id));
        return fromDAddress(dAddress);
    }

    @Override
    public Address saveAddress(Address address) {
        addressRepository.save(toDAddress(address));
        return address;
    }

    private Address fromDAddress(DAddress dAddress) {
        Address address = new Address();
        address.setId(dAddress.getId());
        address.setStreet1(dAddress.getStreet1());
        address.setStreet2(dAddress.getStreet2());
        address.setCity(dAddress.getCity());
        address.setZip(dAddress.getZip());
        address.setProvince(dAddress.getProvince());
        address.setCountry(dAddress.getCountry());
        address.setTelephone(dAddress.getTelephone());
        address.setEmail(dAddress.getEmail());

        return address;
    }

    private DAddress toDAddress(Address address) {
        DAddress dAddress = new DAddress();
        dAddress.setId(address.getId());
        dAddress.setStreet1(address.getStreet1());
        dAddress.setStreet2(address.getStreet2());
        dAddress.setCity(address.getCity());
        dAddress.setZip(address.getZip());
        dAddress.setProvince(address.getProvince());
        dAddress.setCountry(address.getCountry());
        dAddress.setTelephone(address.getTelephone());
        dAddress.setEmail(address.getEmail());

        return dAddress;
    }
}
