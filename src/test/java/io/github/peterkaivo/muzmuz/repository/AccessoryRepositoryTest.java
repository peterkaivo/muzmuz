package io.github.peterkaivo.muzmuz.repository;

import io.github.peterkaivo.muzmuz.common.types.ItemStatus;
import io.github.peterkaivo.muzmuz.repository.model.DAccessory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AccessoryRepositoryTest {

    @Autowired
    private AccessoryRepository accessoryRepository;

    @Test
    public void testRead() {
        DAccessory dAccessory = accessoryRepository.findById(2L).orElse(null);
        assertNotNull(dAccessory);
        assertEquals("ACC002", dAccessory.getInventoryNumber());
        assertEquals("bow", dAccessory.getName());
        assertEquals("my first bow", dAccessory.getAdditionalName());
        assertEquals(25, dAccessory.getDefaultPhoto());
        assertEquals(10, dAccessory.getDefaultGallery());
        assertEquals(ItemStatus.DEPOSITED, dAccessory.getStatus());
        assertEquals(1, dAccessory.getLocation());
        assertEquals(2, dAccessory.getDimensions().size());
        assertEquals(3, dAccessory.getMaterial().size());
        assertEquals("My first bow", dAccessory.getDescription());
        assertEquals("Really a piece of junk", dAccessory.getComments());
    }

    @Test
    public void testReadAll() {
        List<DAccessory> allAccessories = (List<DAccessory>) accessoryRepository.findAll();
        assertNotNull(allAccessories);
        assertEquals(2, allAccessories.size());
    }

    @Test
    public void testCRUD() {
        DAccessory dAccessory1 = new DAccessory(null, "ACC001", "Spare pegs",
                null, 51L, 20L, ItemStatus.LENT, 1L,
                new HashSet<>(Arrays.asList(1L, 2L, 3L)), new HashSet<>(Arrays.asList(4L, 5L)),
                "5 spare violin pegs", null);
        DAccessory dAccessory2 = accessoryRepository.save(dAccessory1);

        DAccessory dAccessory3 = accessoryRepository.findById(dAccessory2.getId()).orElse(null);
        assertNotNull(dAccessory3);
        assertEquals("ACC001", dAccessory3.getInventoryNumber());
        assertEquals("Spare pegs", dAccessory3.getName());
        assertNull(dAccessory3.getAdditionalName());
        assertEquals(51L, dAccessory3.getDefaultPhoto());
        assertEquals(20L, dAccessory3.getDefaultGallery());
        assertEquals(ItemStatus.LENT, dAccessory3.getStatus());
        assertEquals(1L, dAccessory3.getLocation());
        assertEquals(3, dAccessory3.getDimensions().size());
        assertEquals(2, dAccessory3.getMaterial().size());
        assertEquals("5 spare violin pegs", dAccessory3.getDescription());
        assertNull(dAccessory3.getComments());

        dAccessory3.setStatus(ItemStatus.DISCARDED);
        dAccessory3.setComments("Just one comment");
        accessoryRepository.save(dAccessory3);

        DAccessory dAccessory4 = accessoryRepository.findById(dAccessory2.getId()).orElse(null);
        assertNotNull(dAccessory4);
        assertEquals(ItemStatus.DISCARDED, dAccessory4.getStatus());
        assertEquals("Just one comment", dAccessory4.getComments());

        accessoryRepository.deleteById(dAccessory4.getId());

        DAccessory dAccessory5 = accessoryRepository.findById(dAccessory2.getId()).orElse(null);
        assertNull(dAccessory5);
    }
}
