package io.github.peterkaivo.muzmuz.service;

import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundException;
import io.github.peterkaivo.muzmuz.service.model.Location;

import java.util.List;
import java.util.Set;

/**
 * Service class handling {@link io.github.peterkaivo.muzmuz.service.model.Location}
 */
public interface LocationService {
    public List<Location> getAllLocations();
    public Location getLocation(Long id) throws DBObjectNotFoundException;
    public Location saveLocation(Location location);

    /**
     * Function returns {@link Location} object only with following values populated if not null:
     * - Id
     * - Name
     *
     * @param id An ID of the {@link Location} object
     * @return {@link Location} object populated only with values described above or null
     * @throws DBObjectNotFoundException
     */
    public Location getLocationTruncated(Long id) throws DBObjectNotFoundException;
    public Set<Location> getLocationsTruncated(Set<Long> ids);
}
