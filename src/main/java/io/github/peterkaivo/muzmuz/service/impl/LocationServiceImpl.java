package io.github.peterkaivo.muzmuz.service.impl;

import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundException;
import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundExceptionSupplier;
import io.github.peterkaivo.muzmuz.repository.LocationRepository;
import io.github.peterkaivo.muzmuz.repository.model.DLocation;
import io.github.peterkaivo.muzmuz.service.AddressService;
import io.github.peterkaivo.muzmuz.service.LocationService;
import io.github.peterkaivo.muzmuz.service.model.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class LocationServiceImpl implements LocationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(LocationService.class);

    @Autowired
    LocationRepository locationRepository;
    @Autowired
    AddressService addressService;

    @Override
    @Transactional(readOnly = true)
    public List<Location> getAllLocations() {
        List<DLocation> locations = (List<DLocation>) locationRepository.findAll();

        return locations.stream().map(this::fromDLocation).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Location getLocation(Long id) throws DBObjectNotFoundException {
        DLocation dLocation = locationRepository.findById(id).orElseThrow(new DBObjectNotFoundExceptionSupplier(DLocation.class, id));

        return fromDLocation(dLocation);
    }

    @Override
    public Location saveLocation(Location location) {
        locationRepository.save(toDLocation(location));

        return location;
    }

    @Override
    @Transactional(readOnly = true)
    public Location getLocationTruncated(Long id) throws DBObjectNotFoundException {
        DLocation dLocation = locationRepository.findById(id).orElseThrow(new DBObjectNotFoundExceptionSupplier(DLocation.class, id));

        return fromDLocationTruncated(dLocation);
    }

    @Override
    @Transactional(readOnly = true)
    public Set<Location> getLocationsTruncated(Set<Long> ids) {
        Set<Location> locations = new HashSet<>();

        for (Long id : ids) {
            try {
                locations.add(getLocationTruncated(id));
            } catch (DBObjectNotFoundException e) {
                LOGGER.warn("getLocationsTruncated() - DB inconsistency found for DLocation with ID = {}", id);
                LOGGER.info(e.getMessage());
            }
        }

        return locations;
    }

    private Location fromDLocation(DLocation dLocation) {
        Location location = new Location();
        location.setId(dLocation.getId());
        location.setName(dLocation.getName());
        try {
            location.setAddress(dLocation.getAddress() == null ? null : addressService.getAddress(dLocation.getId()));
        } catch (DBObjectNotFoundException e) {
            LOGGER.warn("fromDLocation() - DB inconsistency found for DLocation with ID = {}", dLocation.getId());
            LOGGER.info(e.getMessage());
            location.setAddress(null);
        }
        location.setDescription(dLocation.getDescription());
        location.setComments(dLocation.getComments());

        return location;
    }

    private Location fromDLocationTruncated(DLocation dLocation) {
        Location location = new Location();
        location.setId(dLocation.getId());
        location.setName(dLocation.getName());

        return location;
    }

    private DLocation toDLocation(Location location) {
        DLocation dLocation = new DLocation();
        dLocation.setId(location.getId());
        dLocation.setName(location.getName());
        dLocation.setAddress(location.getAddress() == null ? null : location.getAddress().getId());
        dLocation.setDescription(location.getDescription());
        dLocation.setComments(location.getComments());

        return dLocation;
    }
}
