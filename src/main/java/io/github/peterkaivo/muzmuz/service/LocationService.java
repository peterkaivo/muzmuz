package io.github.peterkaivo.muzmuz.service;

import io.github.peterkaivo.muzmuz.common.exceptions.ItemNotFoundException;
import io.github.peterkaivo.muzmuz.service.model.Location;

import java.util.List;

/**
 * Service class handling {@link io.github.peterkaivo.muzmuz.service.model.Location}
 */
public interface LocationService {
    public List<Location> getAllLocations();
    public Location getLocation(Long id) throws ItemNotFoundException;
    public Location saveLocation(Location acquisition);
}
