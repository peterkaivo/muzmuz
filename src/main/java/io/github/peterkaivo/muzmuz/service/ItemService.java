package io.github.peterkaivo.muzmuz.service;

import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundException;
import io.github.peterkaivo.muzmuz.service.model.Item;

import java.util.List;
import java.util.Set;

/**
 * Service class handling {@link io.github.peterkaivo.muzmuz.service.model.Item}
 */
public interface ItemService {
    public List<Item> getAllItems();
    public Item getItem(Long id) throws DBObjectNotFoundException;
    public Item saveItem(Item item);
    /**
     * Function returns {@link Item} object only with following values populated if not null:
     * - Id
     * - InventoryNumber
     * - Name
     * - Category
     * - DefaultPhoto
     * - Status
     *
     * @param id An ID of the {@link Item} object
     * @return {@link Item} object populated only with values described above or null
     * @throws DBObjectNotFoundException
     */
    public Item getItemTruncated(Long id) throws DBObjectNotFoundException;
    public Set<Item> getItemsTruncated(Set<Long> ids);
}
