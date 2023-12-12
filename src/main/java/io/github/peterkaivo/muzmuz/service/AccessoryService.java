package io.github.peterkaivo.muzmuz.service;

import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundException;
import io.github.peterkaivo.muzmuz.service.model.Accessory;

import java.util.List;
import java.util.Set;

/**
 * Service class handling {@link io.github.peterkaivo.muzmuz.service.model.Accessory}
 */
public interface AccessoryService {
    public List<Accessory> getAllAccessories();
    public Accessory getAccessory(Long id) throws DBObjectNotFoundException;
    public Accessory saveAccessory(Accessory accessory);

    /**
     * Function returns {@link Accessory} object only with following values populated if not null:
     * - Id
     * - InventoryNumber
     * - Name
     * - DefaultPhoto
     *
     * @param id An ID of the {@link Accessory} object
     * @return {@link Accessory} object populated only with values described above or null
     * @throws DBObjectNotFoundException
     */
    public Accessory getAccessoryTruncated(Long id) throws DBObjectNotFoundException;
    public Set<Accessory> getAccessoriesTruncated(Set<Long> ids);
}
