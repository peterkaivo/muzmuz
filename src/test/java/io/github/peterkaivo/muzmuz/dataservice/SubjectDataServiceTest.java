package io.github.peterkaivo.muzmuz.dataservice;

import io.github.peterkaivo.muzmuz.common.types.SubjectType;
import io.github.peterkaivo.muzmuz.dataservice.model.DPerson;
import io.github.peterkaivo.muzmuz.dataservice.model.DSubject;
import io.github.peterkaivo.muzmuz.dataservice.model.DCompany;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SubjectDataServiceTest {

    @Autowired
    private SubjectDataService subjectDataService;

    @Test
    public void testRead() {
        DSubject dSubject = subjectDataService.findById(22L).orElse(null);
        assertNotNull(dSubject);
        assertEquals(SubjectType.COMPANY, dSubject.getSubjectType());
        assertEquals(101L, dSubject.getAddress());
        assertNull(dSubject.getDefaultPhoto());
        assertNull(dSubject.getDefaultGallery());
        assertNull(dSubject.getGalleries());
        assertNull(dSubject.getAudio());
        assertNull(dSubject.getVideo());
        assertNull(dSubject.getFiles());
        assertNull(dSubject.getLinks());
        assertEquals("World-known company that makes not only solid wood guitars.", dSubject.getDescription());
        assertNull(dSubject.getComments());
    }

    @Test
    public void testReadAll() {
        List<DSubject> allSubjects = (List<DSubject>) subjectDataService.findAll();
        assertNotNull(allSubjects);
        assertEquals(2, allSubjects.size());
    }

    @Test
    public void testCRUDCompany() {
        DCompany dCompany1 = new DCompany(null, 1952L, null, null, null,
                null, null, null, null,
                "Acme is acronym and means American Company that Makes Everything", null,
                "Acme Corporation", "1952");
        DCompany dCompany2 = subjectDataService.save(dCompany1);

        DSubject dSubject1 = subjectDataService.findById(dCompany2.getId()).orElse(null);
        assertNotNull(dSubject1);
        assertEquals(SubjectType.COMPANY, dSubject1.getSubjectType());

        DCompany dCompany3 = (DCompany) dSubject1;
        assertEquals(1952L, dCompany3.getAddress());
        assertNull(dCompany3.getDefaultPhoto());
        assertNull(dCompany3.getDefaultGallery());
        assertNull(dCompany3.getGalleries());
        assertNull(dCompany3.getAudio());
        assertNull(dCompany3.getVideo());
        assertNull(dCompany3.getFiles());
        assertNull(dCompany3.getLinks());
        assertEquals("Acme is acronym and means American Company that Makes Everything",
                dCompany3.getDescription());
        assertNull(dCompany3.getComments());
        assertEquals("Acme Corporation", dCompany3.getName());
        assertEquals("1952", dCompany3.getFounded());

        dCompany3.setDescription("Acme is an Ancient Greek word");
        dCompany3.setComments("Actually Acme is not an acronym");
        subjectDataService.save(dCompany3);

        DSubject dSubject2 = subjectDataService.findById(dCompany2.getId()).orElse(null);
        assertNotNull(dSubject2);
        assertEquals(SubjectType.COMPANY, dSubject2.getSubjectType());

        DCompany dCompany4 = (DCompany) dSubject2;
        assertNotNull(dCompany4);
        assertEquals("Acme is an Ancient Greek word", dCompany4.getDescription());
        assertEquals("Actually Acme is not an acronym", dCompany4.getComments());

        subjectDataService.deleteById(dCompany4.getId());

        DSubject dSubject3 = subjectDataService.findById(dCompany2.getId()).orElse(null);
        assertNull(dSubject3);
    }

    @Test
    public void testCRUDPerson() {
        DPerson dPerson1 = new DPerson(null, 1928L, null, null, null,
                null, null, null, null,
                "Engineer, physicist, inventor of Theremin and The Thing", null, "Leon",
                null, "Theremin", "27. 8. 1896");
        DPerson dPerson2 = subjectDataService.save(dPerson1);

        DSubject dSubject1 = subjectDataService.findById(dPerson2.getId()).orElse(null);
        assertNotNull(dSubject1);
        assertEquals(SubjectType.PERSON, dSubject1.getSubjectType());

        DPerson dPerson3 = (DPerson) dSubject1;
        assertEquals(1928L, dPerson3.getAddress());
        assertNull(dPerson3.getDefaultPhoto());
        assertNull(dPerson3.getDefaultGallery());
        assertNull(dPerson3.getGalleries());
        assertNull(dPerson3.getAudio());
        assertNull(dPerson3.getVideo());
        assertNull(dPerson3.getFiles());
        assertNull(dPerson3.getLinks());
        assertEquals("Engineer, physicist, inventor of Theremin and The Thing",
                dPerson3.getDescription());
        assertNull(dPerson3.getComments());
        assertEquals("Leon", dPerson3.getFirstName());
        assertNull(dPerson3.getMiddleName());
        assertEquals("Theremin", dPerson3.getLastName());
        assertEquals("27. 8. 1896", dPerson3.getBirth());

        dPerson3.setFirstName("Lev");
        dPerson3.setMiddleName("Sergejevič");
        dPerson3.setLastName("Těrmien");
        subjectDataService.save(dPerson3);

        DSubject dSubject2 = subjectDataService.findById(dPerson2.getId()).orElse(null);
        assertNotNull(dSubject2);
        assertEquals(SubjectType.PERSON, dSubject2.getSubjectType());

        DPerson dPerson4 = (DPerson) dSubject2;
        assertNotNull(dPerson4);
        assertEquals("Lev", dPerson4.getFirstName());
        assertEquals("Sergejevič", dPerson4.getMiddleName());
        assertEquals("Těrmien", dPerson4.getLastName());

        subjectDataService.deleteById(dPerson4.getId());

        DSubject dSubject3 = subjectDataService.findById(dPerson2.getId()).orElse(null);
        assertNull(dSubject3);
    }
}
