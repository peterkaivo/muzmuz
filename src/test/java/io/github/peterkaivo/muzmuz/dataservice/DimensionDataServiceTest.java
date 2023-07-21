package io.github.peterkaivo.muzmuz.dataservice;

import io.github.peterkaivo.muzmuz.common.types.DimensionType;
import io.github.peterkaivo.muzmuz.common.types.Unit;
import io.github.peterkaivo.muzmuz.dataservice.model.DDimension;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DimensionDataServiceTest {

    @Autowired
    private DimensionDataService dimensionDataService;

    @Test
    public void testRead() {
        DDimension dDimension = dimensionDataService.findById(2L).orElse(null);
        assertNotNull(dDimension);
        assertEquals(DimensionType.ANGLE, dDimension.getDimensionType());
        assertEquals(90.0f, dDimension.getDimensionValue());
        assertEquals(Unit.DEG, dDimension.getUnit());
        assertEquals("Right angle", dDimension.getDescription());
        assertEquals("That is right", dDimension.getComments());
    }

    @Test
    public void testReadAll() {
        List<DDimension> allDimensions = (List<DDimension>) dimensionDataService.findAll();
        assertNotNull(allDimensions);
        assertEquals(2, allDimensions.size());
    }

    @Test
    public void testCRUD() {
        DDimension dDimension1 = new DDimension(null, DimensionType.ANGLE, 45.0f, Unit.DEG,
                "Half of the right angle", "No Comment");
        DDimension dDimension2 = dimensionDataService.save(dDimension1);

        DDimension dDimension3 = dimensionDataService.findById(dDimension2.getId()).orElse(null);
        assertNotNull(dDimension3);
        assertEquals(DimensionType.ANGLE, dDimension3.getDimensionType());
        assertEquals(45.0f, dDimension3.getDimensionValue());
        assertEquals(Unit.DEG, dDimension3.getUnit());
        assertEquals("Half of the right angle", dDimension3.getDescription());
        assertEquals("No Comment", dDimension3.getComments());

        dDimension3.setDimensionValue(90.0f);
        dDimension3.setDescription("Now it is right angle");
        dimensionDataService.save(dDimension3);

        DDimension dDimension4 = dimensionDataService.findById(dDimension2.getId()).orElse(null);
        assertNotNull(dDimension4);
        assertEquals(90.0f, dDimension4.getDimensionValue());
        assertEquals("Now it is right angle", dDimension4.getDescription());

        dimensionDataService.deleteById(dDimension4.getId());

        DDimension dDimension5 = dimensionDataService.findById(dDimension2.getId()).orElse(null);
        assertNull(dDimension5);
    }
}
