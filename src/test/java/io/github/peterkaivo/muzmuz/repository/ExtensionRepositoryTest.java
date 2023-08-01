package io.github.peterkaivo.muzmuz.repository;

import io.github.peterkaivo.muzmuz.repository.model.DExtension;
import io.github.peterkaivo.muzmuz.repository.model.DStrings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ExtensionRepositoryTest {

    @Autowired
    private ExtensionRepository extensionRepository;

    @Test
    public void testRead() {
        DExtension dExtension = extensionRepository.findById(22L).orElse(null);
        assertNotNull(dExtension);
        assertEquals("Baritone ukulele - standard", dExtension.getName());
        assertEquals("default_strings", dExtension.getTemplateName());
        assertEquals("String setup of standard baritone ukulele with low D", dExtension.getDescription());
        assertNull(dExtension.getComments());
    }

    @Test
    public void testReadAll() {
        List<DExtension> allExtensions = (List<DExtension>) extensionRepository.findAll();
        assertNotNull(allExtensions);
        assertEquals(2, allExtensions.size());
    }

    @Test
    public void testStringsCRUD() {
        DStrings dStrings1 = new DStrings(null, "ErHu", "default_strings", "String setup for Chinese soprano ErHu",
                null, Arrays.asList(155L, 156L), 81L);
        DStrings dStrings2 = extensionRepository.save(dStrings1);

        DExtension dExtension1 = extensionRepository.findById(dStrings2.getId()).orElse(null);
        assertNotNull(dExtension1);
        assertEquals(DStrings.class, dExtension1.getClass());

        DStrings dStrings3 = (DStrings) dExtension1;
        assertEquals("ErHu", dStrings3.getName());
        assertEquals("default_strings", dStrings3.getTemplateName());
        assertEquals("String setup for Chinese soprano ErHu", dStrings3.getDescription());
        assertNull(dStrings3.getComments());
        assertEquals(2, dStrings3.getStrings().size());
        assertEquals(81L, dStrings3.getSchema());

        dStrings3.setSchema(82L);
        dStrings3.setComments("No Comment");
        extensionRepository.save(dStrings3);

        DExtension dExtension2 = extensionRepository.findById(dStrings2.getId()).orElse(null);
        assertNotNull(dExtension2);

        DStrings dStrings4 = (DStrings) dExtension2;
        assertEquals(82L, dStrings4.getSchema());
        assertEquals("No Comment", dStrings4.getComments());

        extensionRepository.deleteById(dStrings4.getId());

        DExtension dExtension3 = extensionRepository.findById(dStrings2.getId()).orElse(null);
        assertNull(dExtension3);
    }
}
