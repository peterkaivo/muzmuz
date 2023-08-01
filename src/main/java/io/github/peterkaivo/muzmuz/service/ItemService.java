package io.github.peterkaivo.muzmuz.service;

import io.github.peterkaivo.muzmuz.common.exceptions.ItemNotFoundException;
import io.github.peterkaivo.muzmuz.service.model.Item;

import java.util.List;

/**
 * Service class handling {@link io.github.peterkaivo.muzmuz.service.model.Item}
 */
public interface ItemService {
    public List<Item> getAllItems();
    public Item getItem(Long id) throws ItemNotFoundException;
    public Item saveItem(Item acquisition);
}
