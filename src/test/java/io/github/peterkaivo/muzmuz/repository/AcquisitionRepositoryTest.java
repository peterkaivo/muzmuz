package io.github.peterkaivo.muzmuz.repository;

import io.github.peterkaivo.muzmuz.common.types.AcquisitionType;
import io.github.peterkaivo.muzmuz.repository.model.DAcquisition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AcquisitionRepositoryTest {

    @Autowired
    private AcquisitionRepository acquisitionRepository;

    @Test
    public void testRead() {
        DAcquisition dAcquisition = acquisitionRepository.findById(2L).orElse(null);
        assertNotNull(dAcquisition);
        assertEquals(AcquisitionType.DONATION, dAcquisition.getAcquisitionType());
        assertEquals("2. 2. 2222", dAcquisition.getAcquisitionDate());
        assertEquals(4L, dAcquisition.getAcquiredFrom());
        assertEquals(4, dAcquisition.getAcquiredItems().size());
        assertEquals(4L, dAcquisition.getDefaultGallery());
        assertEquals(2, dAcquisition.getGalleries().size());
        assertEquals(2, dAcquisition.getAudio().size());
        assertEquals(2, dAcquisition.getVideo().size());
        assertEquals(2, dAcquisition.getFiles().size());
        assertEquals(2, dAcquisition.getLinks().size());
        assertEquals("Donation from an old man", dAcquisition.getDescription());
        assertEquals("That was a lucky day", dAcquisition.getComments());
    }

    @Test
    public void testReadAll() {
        List<DAcquisition> allAcquisitions = (List<DAcquisition>) acquisitionRepository.findAll();
        assertNotNull(allAcquisitions);
        assertEquals(2, allAcquisitions.size());
    }

    @Test
    public void testCRUD() {
        DAcquisition dAcquisition1 = new DAcquisition(null, AcquisitionType.PURCHASE,
                "1. 4. 2023", 2L, Collections.singleton(1L),
                null, null, null, null, null, null,
                "My very first Item I bought",
                "That was an amazing shop");
        DAcquisition dAcquisition2 = acquisitionRepository.save(dAcquisition1);

        DAcquisition dAcquisition3 = acquisitionRepository.findById(dAcquisition2.getId()).orElse(null);
        assertNotNull(dAcquisition3);
        assertEquals(AcquisitionType.PURCHASE, dAcquisition3.getAcquisitionType());
        assertEquals("1. 4. 2023", dAcquisition3.getAcquisitionDate());
        assertEquals(2L, dAcquisition3.getAcquiredFrom());
        assertEquals(1, dAcquisition3.getAcquiredItems().size());
        assertNull(dAcquisition3.getDefaultGallery());
        assertNull(dAcquisition3.getGalleries());
        assertNull(dAcquisition3.getAudio());
        assertNull(dAcquisition3.getVideo());
        assertNull(dAcquisition3.getFiles());
        assertNull(dAcquisition3.getLinks());
        assertEquals("My very first Item I bought", dAcquisition3.getDescription());
        assertEquals("That was an amazing shop", dAcquisition3.getComments());

        dAcquisition3.setVideo(Collections.singleton(3L));
        dAcquisition3.setDescription("April fool!");
        acquisitionRepository.save(dAcquisition3);

        DAcquisition dAcquisition4 = acquisitionRepository.findById(dAcquisition2.getId()).orElse(null);
        assertNotNull(dAcquisition4);
        assertEquals(1, dAcquisition4.getVideo().size());
        assertEquals("April fool!", dAcquisition4.getDescription());

        acquisitionRepository.deleteById(dAcquisition4.getId());

        DAcquisition dAcquisition5 = acquisitionRepository.findById(dAcquisition2.getId()).orElse(null);
        assertNull(dAcquisition5);
    }
}
