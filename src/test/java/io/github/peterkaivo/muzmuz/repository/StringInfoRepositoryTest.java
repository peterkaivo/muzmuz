package io.github.peterkaivo.muzmuz.repository;

import io.github.peterkaivo.muzmuz.repository.model.DStringInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StringInfoRepositoryTest {

    @Autowired
    private StringInfoRepository stringInfoRepository;

    @Test
    public void testRead() {
        DStringInfo dStringInfo = stringInfoRepository.findById(2L).orElse(null);
        assertNotNull(dStringInfo);
        assertEquals(3, dStringInfo.getStringOrder());
        assertEquals("A4", dStringInfo.getPitch());
        assertEquals(6552L, dStringInfo.getThickness());
        assertEquals(442L, dStringInfo.getMaterial());
        assertEquals("silver coated violin string", dStringInfo.getDescription());
        assertNull(dStringInfo.getComments());
    }

    @Test
    public void testReadAll() {
        List<DStringInfo> allStringInfos = (List<DStringInfo>) stringInfoRepository.findAll();
        assertNotNull(allStringInfos);
        assertEquals(2, allStringInfos.size());
    }

    @Test
    public void testCRUD() {
        DStringInfo dStringInfo1 = new DStringInfo(null, 1, "E1", 6949L, 41L,
                "several sheep guts twisted together", null);
        DStringInfo dStringInfo2 = stringInfoRepository.save(dStringInfo1);

        DStringInfo dStringInfo3 = stringInfoRepository.findById(dStringInfo2.getId()).orElse(null);
        assertNotNull(dStringInfo3);
        assertEquals(1, dStringInfo3.getStringOrder());
        assertEquals("E1", dStringInfo3.getPitch());
        assertEquals(6949L, dStringInfo3.getThickness());
        assertEquals(41L, dStringInfo3.getMaterial());
        assertEquals("several sheep guts twisted together", dStringInfo3.getDescription());
        assertNull(dStringInfo3.getComments());

        dStringInfo3.setDescription("several sheep guts twisted together - mutton serosa");
        dStringInfo3.setComments("Needs oiling");
        stringInfoRepository.save(dStringInfo3);

        DStringInfo dStringInfo4 = stringInfoRepository.findById(dStringInfo2.getId()).orElse(null);
        assertNotNull(dStringInfo4);
        assertEquals("several sheep guts twisted together - mutton serosa", dStringInfo4.getDescription());
        assertEquals("Needs oiling", dStringInfo4.getComments());

        stringInfoRepository.deleteById(dStringInfo4.getId());

        DStringInfo dStringInfo5 = stringInfoRepository.findById(dStringInfo2.getId()).orElse(null);
        assertNull(dStringInfo5);
    }
}
