package io.github.peterkaivo.muzmuz.dataservice;

import io.github.peterkaivo.muzmuz.dataservice.model.DLocation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class LocationDataServiceTest {

    @Autowired
    private LocationDataService locationDataService;

    @Test
    public void testRead() {
        DLocation dLocation = locationDataService.findById(2L).orElse(null);
        assertNotNull(dLocation);
        assertEquals("Czech Museum of Music", dLocation.getName());
        assertEquals(2L, dLocation.getAddress());
        assertEquals("Part of the Czech National Museum devoted to music and musical instruments",
                dLocation.getDescription());
        assertNull(dLocation.getComments());
    }

    @Test
    public void testReadAll() {
        List<DLocation> allLocations = (List<DLocation>) locationDataService.findAll();
        assertNotNull(allLocations);
        assertEquals(2, allLocations.size());
    }

    @Test
    public void testCRUD() {
        DLocation dLocation1 = new DLocation(null, "Stefan's instruments", 28L,
                "An old guy's small music shop with interesting old instruments", null);
        DLocation dLocation2 = locationDataService.save(dLocation1);

        DLocation dLocation3 = locationDataService.findById(dLocation2.getId()).orElse(null);
        assertNotNull(dLocation3);
        assertEquals("Stefan's instruments", dLocation3.getName());
        assertEquals(28L, dLocation3.getAddress());
        assertEquals("An old guy's small music shop with interesting old instruments",
                dLocation3.getDescription());
        assertNull(dLocation3.getComments());

        dLocation3.setDescription(dLocation3.getDescription() + " - in the basement of apartment house");
        dLocation3.setComments("He called me he had a new viola for me");
        locationDataService.save(dLocation3);

        DLocation dLocation4 = locationDataService.findById(dLocation2.getId()).orElse(null);
        assertNotNull(dLocation4);
        assertEquals("An old guy's small music shop with interesting old instruments - in the basement of apartment house",
                dLocation4.getDescription());
        assertEquals("He called me he had a new viola for me", dLocation4.getComments());

        locationDataService.deleteById(dLocation4.getId());

        DLocation dLocation5 = locationDataService.findById(dLocation2.getId()).orElse(null);
        assertNull(dLocation5);
    }
}
