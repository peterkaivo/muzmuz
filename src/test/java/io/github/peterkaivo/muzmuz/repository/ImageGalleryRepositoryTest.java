package io.github.peterkaivo.muzmuz.repository;

import io.github.peterkaivo.muzmuz.repository.model.DImageGallery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ImageGalleryRepositoryTest {

    @Autowired
    private ImageGalleryRepository imageGalleryRepository;

    @Test
    public void testRead() {
        DImageGallery dImageGallery = imageGalleryRepository.findById(2L).orElse(null);
        assertNotNull(dImageGallery);
        assertEquals("Portfolio of Francisco Farina", dImageGallery.getName());
        assertEquals(5, dImageGallery.getImages().size());
        assertEquals("Photo collection of Timples Canario made by Francisco Farina luthier from Tenerife",
                dImageGallery.getDescription());
        assertEquals("Name Farina should have contained tilda char over 'n' char, but I had problem with SQL insert",
                dImageGallery.getComments());
    }

    @Test
    public void testReadAll() {
        List<DImageGallery> allImageGalleries = (List<DImageGallery>) imageGalleryRepository.findAll();
        assertNotNull(allImageGalleries);
        assertEquals(2, allImageGalleries.size());
    }

    @Test
    public void testCRUD() {
        DImageGallery dImageGallery1 = new DImageGallery(null, "Violin Josef Múčka op. 40",
                new HashSet<>(Arrays.asList(201L, 202L, 203L)),
                "Violin made in 2014 by luthier Josef Múčka from Strání village as his 40th instrument", null);
        DImageGallery dImageGallery2 = imageGalleryRepository.save(dImageGallery1);

        DImageGallery dImageGallery3 = imageGalleryRepository.findById(dImageGallery2.getId()).orElse(null);
        assertNotNull(dImageGallery3);
        assertEquals("Violin Josef Múčka op. 40", dImageGallery3.getName());
        assertEquals(3, dImageGallery3.getImages().size());
        assertEquals("Violin made in 2014 by luthier Josef Múčka from Strání village as his 40th instrument",
                dImageGallery3.getDescription());
        assertNull(dImageGallery3.getComments());

        dImageGallery3.getImages().addAll(Arrays.asList(204L, 205L));
        dImageGallery3.setComments("I have to upload more photos!");
        imageGalleryRepository.save(dImageGallery3);

        DImageGallery dImageGallery4 = imageGalleryRepository.findById(dImageGallery2.getId()).orElse(null);
        assertNotNull(dImageGallery4);
        assertEquals(5, dImageGallery4.getImages().size());
        assertEquals("I have to upload more photos!", dImageGallery4.getComments());

        imageGalleryRepository.deleteById(dImageGallery4.getId());

        DImageGallery dImageGallery5 = imageGalleryRepository.findById(dImageGallery2.getId()).orElse(null);
        assertNull(dImageGallery5);
    }
}
