package io.github.peterkaivo.muzmuz.dataservice;

import io.github.peterkaivo.muzmuz.common.types.MediaType;
import io.github.peterkaivo.muzmuz.common.utils.DateUtils;
import io.github.peterkaivo.muzmuz.dataservice.model.DVideo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class VideoDataServiceTest {

    @Autowired
    private VideoDataService videoDataService;

    @Test
    public void testRead() {
        DVideo dVideo = videoDataService.findById(2L).orElse(null);
        assertNotNull(dVideo);
        assertEquals(MediaType.VIDEO, dVideo.getType());
        assertEquals("Vogon poesy reading record", dVideo.getName());
        assertEquals("poesy_reading.avi", dVideo.getFileName());
        assertEquals("42:42", dVideo.getLength());
        assertEquals("4242x2424", dVideo.getResolution());
        assertEquals("4. 2. 4242", dVideo.getAcquired());
        assertEquals("Live event record from Carnegie Hall", dVideo.getDescription());
        assertEquals("Hear that and die", dVideo.getComments());
    }

    @Test
    public void testReadAll() {
        List<DVideo> allVideos = (List<DVideo>) videoDataService.findAll();
        assertNotNull(allVideos);
        assertEquals(2, allVideos.size());
    }

    @Test
    public void testCRUD() {
        DVideo dVideo1 = new DVideo(null, "Panjo model D2 promo video", "panjo_promo.mp4", "Short advertorial video introducing new Panjo model D2",
                "Finally a playable model", "1:23", "4096x1716", "1. 4. 2023");
        DVideo dVideo2 = videoDataService.save(dVideo1);

        DVideo dVideo3 = videoDataService.findById(dVideo2.getId()).orElse(null);
        assertNotNull(dVideo3);
        assertEquals(MediaType.VIDEO, dVideo3.getType());
        assertEquals("Panjo model D2 promo video", dVideo3.getName());
        assertEquals("panjo_promo.mp4", dVideo3.getFileName());
        assertEquals("1:23", dVideo3.getLength());
        assertEquals("4096x1716", dVideo3.getResolution());
        assertEquals("1. 4. 2023", dVideo3.getAcquired());
        assertEquals("Short advertorial video introducing new Panjo model D2", dVideo3.getDescription());
        assertEquals("Finally a playable model", dVideo3.getComments());

        dVideo3.setFileName("panjo_promo.avi");
        dVideo3.setAcquired("2. 4. 2023");
        videoDataService.save(dVideo3);

        DVideo dVideo4 = videoDataService.findById(dVideo2.getId()).orElse(null);
        assertNotNull(dVideo4);
        assertEquals("panjo_promo.avi", dVideo4.getFileName());
        assertEquals("2. 4. 2023", dVideo4.getAcquired());

        videoDataService.deleteById(dVideo4.getId());

        DVideo dVideo5 = videoDataService.findById(dVideo2.getId()).orElse(null);
        assertNull(dVideo5);
    }
}
