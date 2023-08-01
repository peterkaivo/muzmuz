package io.github.peterkaivo.muzmuz.repository;

import io.github.peterkaivo.muzmuz.common.types.MediaType;
import io.github.peterkaivo.muzmuz.repository.model.DFile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class FileRepositoryTest {

    @Autowired
    private FileRepository fileRepository;

    @Test
    public void testRead() {
        DFile dFile = fileRepository.findById(2L).orElse(null);
        assertNotNull(dFile);
        assertEquals(MediaType.FILE, dFile.getType());
        assertEquals("Hurdy-gurdy for dummies", dFile.getName());
        assertEquals("manual.pdf", dFile.getFileName());
        assertEquals("Play techniques and maintenance documentation", dFile.getDescription());
        assertEquals("It's really for total dummies", dFile.getComments());
    }

    @Test
    public void testReadAll() {
        List<DFile> allFiles = (List<DFile>) fileRepository.findAll();
        assertNotNull(allFiles);
        assertEquals(2, allFiles.size());
    }

    @Test
    public void testCRUD() {
        DFile dFile1 = new DFile(null, "Catalogue of stolen musical instruments from backseat of a car",
                "catalogue.pdf", "Catalogue of 3,141,593 stolen instruments", null);
        DFile dFile2 = fileRepository.save(dFile1);

        DFile dFile3 = fileRepository.findById(dFile2.getId()).orElse(null);
        assertNotNull(dFile3);
        assertEquals(MediaType.FILE, dFile3.getType());
        assertEquals("Catalogue of stolen musical instruments from backseat of a car", dFile3.getName());
        assertEquals("catalogue.pdf", dFile3.getFileName());
        assertEquals("Catalogue of 3,141,593 stolen instruments", dFile3.getDescription());
        assertNull(dFile3.getComments());

        dFile3.setDescription("Catalogue of 2,718,282 stolen instruments");
        dFile3.setComments("Several were stolen from a front seat");
        fileRepository.save(dFile3);

        DFile dFile4 = fileRepository.findById(dFile2.getId()).orElse(null);
        assertNotNull(dFile4);
        assertEquals("Catalogue of 2,718,282 stolen instruments", dFile4.getDescription());
        assertEquals("Several were stolen from a front seat", dFile4.getComments());

        fileRepository.deleteById(dFile4.getId());

        DFile dFile5 = fileRepository.findById(dFile2.getId()).orElse(null);
        assertNull(dFile5);
    }
}
