package io.github.peterkaivo.muzmuz.service;

import io.github.peterkaivo.muzmuz.common.exceptions.ItemNotFoundException;
import io.github.peterkaivo.muzmuz.service.model.Accessory;

import java.util.List;

/**
 * Service class handling {@link io.github.peterkaivo.muzmuz.service.model.Accessory}
 */
public interface AccessoryService {
    public List<Accessory> getAllAccessories();
    public Accessory getAccessory(Long id) throws ItemNotFoundException;
    public Accessory saveAccessory(Accessory accessory);
}
