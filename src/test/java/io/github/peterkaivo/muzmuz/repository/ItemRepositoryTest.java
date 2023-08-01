package io.github.peterkaivo.muzmuz.repository;

import io.github.peterkaivo.muzmuz.common.types.ItemStatus;
import io.github.peterkaivo.muzmuz.repository.model.DItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void testRead() {
        DItem dItem = itemRepository.findById(2001L).orElse(null);
        assertNotNull(dItem);
        assertEquals("I2001", dItem.getInventoryNumber());
        assertEquals("Panjo", dItem.getName());
        assertEquals("Panjo model D2", dItem.getAdditionalName());
        assertEquals("/musical instruments/chordophones/plucked", dItem.getCategory());
        assertEquals(2001L, dItem.getDefaultPhoto());
        assertEquals(ItemStatus.SOLD, dItem.getStatus());
        assertEquals("Improved version of model D", dItem.getDescription());
        assertEquals(1, dItem.getLabels().size());
        assertEquals(1, dItem.getDrawings().size());
        assertEquals(5, dItem.getDimensions().size());
        assertEquals(5, dItem.getMaterial().size());
        assertEquals(21L, dItem.getLocation());
        assertEquals(21L, dItem.getOwner());
        assertEquals(2002L, dItem.getCurrentConditions());
        assertNull(dItem.getComments());
        assertEquals("2021", dItem.getManufactureDate());
        assertEquals(1, dItem.getManufacturers().size());
        assertEquals(2001L, dItem.getAcquisition());
        assertEquals(2001L, dItem.getAcquisitionCondition());
        assertEquals(2001L, dItem.getDefaultGallery());
        assertEquals(1, dItem.getGalleries().size());
        assertNull(dItem.getAudio());
        assertNull(dItem.getVideo());
        assertNull(dItem.getFiles());
        assertNull(dItem.getLinks());
        assertEquals(1, dItem.getExtensions().size());
        assertNull(dItem.getAccessories());
    }

    @Test
    public void testReadAll() {
        List<DItem> allItems = (List<DItem>) itemRepository.findAll();
        assertNotNull(allItems);
        assertEquals(2, allItems.size());
    }

    @Test
    public void testCRUD() {
        DItem dItem1 = new DItem(null, "I0011", "Dragon of Brno", "Double-bass",
                "/musical instruments/chordophones/bowed", 1111L, ItemStatus.EXPOSED,
                "An old half-solid-wood double-bass hanged below the ceiling", null, null,
                null, null, 21L, 21L, 1112L, null,
                null, null, 1111L, 1111L, 1111L,
                new HashSet<>(List.of(1111L)), null, null, null, null,
                new HashSet<>(List.of(1111L)), null);
        DItem dItem2 = itemRepository.save(dItem1);

        DItem dItem3 = itemRepository.findById(dItem2.getId()).orElse(null);
        assertNotNull(dItem3);
        assertEquals("I0011", dItem1.getInventoryNumber());
        assertEquals("Dragon of Brno", dItem1.getName());
        assertEquals("Double-bass", dItem1.getAdditionalName());
        assertEquals("/musical instruments/chordophones/bowed", dItem1.getCategory());
        assertEquals(1111L, dItem1.getDefaultPhoto());
        assertEquals(ItemStatus.EXPOSED, dItem1.getStatus());
        assertEquals("An old half-solid-wood double-bass hanged below the ceiling", dItem1.getDescription());
        assertNull(dItem1.getLabels());
        assertNull(dItem1.getDrawings());
        assertNull(dItem1.getDimensions());
        assertNull(dItem1.getMaterial());
        assertEquals(21L, dItem1.getLocation());
        assertEquals(21L, dItem1.getOwner());
        assertEquals(1112L, dItem1.getCurrentConditions());
        assertNull(dItem1.getComments());
        assertNull(dItem1.getManufactureDate());
        assertNull(dItem1.getManufacturers());
        assertEquals(1111L, dItem1.getAcquisition());
        assertEquals(1111L, dItem1.getAcquisitionCondition());
        assertEquals(1111L, dItem1.getDefaultGallery());
        assertEquals(1, dItem1.getGalleries().size());
        assertNull(dItem1.getAudio());
        assertNull(dItem1.getVideo());
        assertNull(dItem1.getFiles());
        assertNull(dItem1.getLinks());
        assertEquals(1, dItem1.getExtensions().size());
        assertNull(dItem1.getAccessories());

        dItem3.setLabels(new HashSet<>(List.of("dragon")));
        dItem3.setComments("It hangs like a real Dragon of Brno");
        itemRepository.save(dItem3);

        DItem dItem4 = itemRepository.findById(dItem2.getId()).orElse(null);
        assertNotNull(dItem4);
        assertEquals(1, dItem4.getLabels().size());
        assertTrue(dItem4.getLabels().contains("dragon"));
        assertEquals("It hangs like a real Dragon of Brno", dItem4.getComments());

        itemRepository.deleteById(dItem4.getId());

        DItem dItem5 = itemRepository.findById(dItem2.getId()).orElse(null);
        assertNull(dItem5);
    }
}
