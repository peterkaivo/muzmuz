package io.github.peterkaivo.muzmuz.dataservice;

import io.github.peterkaivo.muzmuz.common.types.MediaType;
import io.github.peterkaivo.muzmuz.dataservice.model.DDrawing;
import io.github.peterkaivo.muzmuz.dataservice.model.DGraphics;
import io.github.peterkaivo.muzmuz.dataservice.model.DImage;
import io.github.peterkaivo.muzmuz.dataservice.model.DPhoto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GraphicsDataServiceTest {

    @Autowired
    private GraphicsDataService graphicsDataService;

    @Test
    public void testRead() {
        DGraphics dGraphics = graphicsDataService.findById(22L).orElse(null);
        assertNotNull(dGraphics);
        assertEquals(MediaType.IMAGE, dGraphics.getType());
        assertEquals("Panjo model D2 chords cheat sheet", dGraphics.getName());
        assertEquals("panjoD2_chords.jpg", dGraphics.getFileName());
        assertEquals("1920x1080", dGraphics.getResolution());
        assertNull(dGraphics.getAcquired());
        assertEquals("Cheat sheet of common chords played on panjo model D2", dGraphics.getDescription());
        assertNull(dGraphics.getComments());
    }

    @Test
    public void testReadAll() {
        List<DGraphics> allGraphics = (List<DGraphics>) graphicsDataService.findAll();
        assertNotNull(allGraphics);
        assertEquals(2, allGraphics.size());
    }

    @Test
    public void testCRUDPhoto() {
        DPhoto dPhoto1 = new DPhoto(null, "Viola act", "viola_act.raw",
                "Hi-res HDR photo of a viola completely naked", "Even without chin rest", "69x69", null);
        DPhoto dPhoto2 = graphicsDataService.save(dPhoto1);

        DGraphics dGraphics1 = graphicsDataService.findById(dPhoto2.getId()).orElse(null);
        assertNotNull(dGraphics1);
        assertEquals(MediaType.PHOTO, dGraphics1.getType());

        DPhoto dPhoto3 = (DPhoto) dGraphics1;
        assertEquals("Viola act", dPhoto3.getName());
        assertEquals("viola_act.raw", dPhoto3.getFileName());
        assertEquals("69x69", dPhoto3.getResolution());
        assertNull(dPhoto3.getAcquired());
        assertEquals("Hi-res HDR photo of a viola completely naked", dPhoto3.getDescription());
        assertEquals("Even without chin rest", dPhoto3.getComments());

        dPhoto3.setFileName("viola_act.jpg");
        dPhoto3.setComments("I've rather photoshopped her a chin rest");
        graphicsDataService.save(dPhoto3);

        DGraphics dGraphics2 = graphicsDataService.findById(dPhoto2.getId()).orElse(null);
        assertNotNull(dGraphics2);
        assertEquals(MediaType.PHOTO, dGraphics2.getType());

        DPhoto dPhoto4 = (DPhoto) dGraphics2;
        assertNotNull(dPhoto4);
        assertEquals("viola_act.jpg", dPhoto4.getFileName());
        assertEquals("I've rather photoshopped her a chin rest", dPhoto4.getComments());

        graphicsDataService.deleteById(dPhoto4.getId());

        DGraphics dGraphics3 = graphicsDataService.findById(dPhoto2.getId()).orElse(null);
        assertNull(dGraphics3);
    }

    @Test
    public void testCRUDImage() {
        DImage dImage1 = new DImage(null, "Electric violin concept 2", "eviolin2.jpg",
                "Graphic design of new electric violin No. 2", "This concept won't be realized", "1920x1080", null);
        DImage dImage2 = graphicsDataService.save(dImage1);

        DGraphics dGraphics1 = graphicsDataService.findById(dImage2.getId()).orElse(null);
        assertNotNull(dGraphics1);
        assertEquals(MediaType.IMAGE, dGraphics1.getType());

        DImage dImage3 = (DImage) dGraphics1;
        assertEquals("Electric violin concept 2", dImage3.getName());
        assertEquals("eviolin2.jpg", dImage3.getFileName());
        assertEquals("1920x1080", dImage3.getResolution());
        assertNull(dImage3.getAcquired());
        assertEquals("Graphic design of new electric violin No. 2", dImage3.getDescription());
        assertEquals("This concept won't be realized", dImage3.getComments());

        dImage3.setDescription("Graphic design of new electric violin No. 2 - to be realized");
        dImage3.setComments("I've changed my mind, this concept will be realized");
        graphicsDataService.save(dImage3);

        DGraphics dGraphics2 = graphicsDataService.findById(dImage2.getId()).orElse(null);
        assertNotNull(dGraphics2);
        assertEquals(MediaType.IMAGE, dGraphics2.getType());

        DImage dImage4 = (DImage) dGraphics2;
        assertNotNull(dImage4);
        assertEquals("Graphic design of new electric violin No. 2 - to be realized", dImage4.getDescription());
        assertEquals("I've changed my mind, this concept will be realized", dImage4.getComments());

        graphicsDataService.deleteById(dImage4.getId());

        DGraphics dGraphics3 = graphicsDataService.findById(dImage2.getId()).orElse(null);
        assertNull(dGraphics3);
    }

    @Test
    public void testCRUDDrawing() {
        DDrawing dDrawing1 = new DDrawing(null, "Grand cimbalom", "cimbal_schema.jpg",
                "Dimension and constraints schema of grand cimbalom", null, "1024x768", null);
        DDrawing dDrawing2 = graphicsDataService.save(dDrawing1);

        DGraphics dGraphics1 = graphicsDataService.findById(dDrawing2.getId()).orElse(null);
        assertNotNull(dGraphics1);
        assertEquals(MediaType.DRAWING, dGraphics1.getType());

        DDrawing dDrawing3 = (DDrawing) dGraphics1;
        assertEquals("Grand cimbalom", dDrawing3.getName());
        assertEquals("cimbal_schema.jpg", dDrawing3.getFileName());
        assertEquals("1024x768", dDrawing3.getResolution());
        assertNull(dDrawing3.getAcquired());
        assertEquals("Dimension and constraints schema of grand cimbalom", dDrawing3.getDescription());
        assertNull(dDrawing3.getComments());

        dDrawing3.setName("Concert cimbalom");
        dDrawing3.setDescription("Dimension and constraints schema of concert cimbalom");
        graphicsDataService.save(dDrawing3);

        DGraphics dGraphics2 = graphicsDataService.findById(dDrawing2.getId()).orElse(null);
        assertNotNull(dGraphics2);
        assertEquals(MediaType.DRAWING, dGraphics2.getType());

        DDrawing dDrawing4 = (DDrawing) dGraphics2;
        assertNotNull(dDrawing4);
        assertEquals("Concert cimbalom", dDrawing4.getName());
        assertEquals("Dimension and constraints schema of concert cimbalom", dDrawing4.getDescription());

        graphicsDataService.deleteById(dDrawing4.getId());

        DGraphics dGraphics3 = graphicsDataService.findById(dDrawing2.getId()).orElse(null);
        assertNull(dGraphics3);
    }
}
