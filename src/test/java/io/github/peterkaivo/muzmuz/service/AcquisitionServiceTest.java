package io.github.peterkaivo.muzmuz.service;

import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundException;
import io.github.peterkaivo.muzmuz.common.types.AcquisitionType;
import io.github.peterkaivo.muzmuz.common.types.ItemStatus;
import io.github.peterkaivo.muzmuz.repository.AcquisitionRepository;
import io.github.peterkaivo.muzmuz.repository.model.DAcquisition;
import io.github.peterkaivo.muzmuz.service.model.Acquisition;
import io.github.peterkaivo.muzmuz.service.model.Item;
import io.github.peterkaivo.muzmuz.service.model.Person;
import io.github.peterkaivo.muzmuz.service.model.Subject;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@SpringBootTest
public class AcquisitionServiceTest {
    @Autowired
    private AcquisitionService acquisitionService;
    @MockBean
    private AcquisitionRepository acquisitionRepository;
    @MockBean
    private SubjectService subjectService;
    @MockBean
    private ItemService itemService;
    @MockBean
    private ImageGalleryService imageGalleryService;
    @MockBean
    private AudioService audioService;
    @MockBean
    private VideoService videoService;
    @MockBean
    private FileService fileService;
    @MockBean
    private LinkService linkService;

    @Test
    public void testGetAllAcquisitions() {
        given(acquisitionRepository.findAll()).willAnswer(invocation -> Arrays.asList(
                new DAcquisition(1L, AcquisitionType.PURCHASE, "1. 1. 1111", 1L, Collections.singleton(1L), null, null, null, null, null, null, "1st acquisition", null),
                new DAcquisition(2L, AcquisitionType.PURCHASE, "2. 2. 2222", 2L, new HashSet<>(Arrays.asList(2L, 3L)), null, null, null, null, null, null, "2nd acquisition", null)
        ));

        List<Acquisition> acquisitions = acquisitionService.getAllAcquisitions();

        assertNotNull(acquisitions);
        assertEquals(2, acquisitions.size());
    }

    @Test
    public void testGetAcquisition() throws DBObjectNotFoundException {
        given(acquisitionRepository.findById(1L)).willReturn(Optional.of(new DAcquisition(1L, AcquisitionType.PURCHASE, "1. 1. 1111", 1L, Collections.singleton(1L), null, null, null, null, null, null, "1st acquisition", null)));

        Subject subject = new Person(1L, null, null, null, null, null, null, null, null, null, null, "Jiří", "Jan", "Mahdal", "1. 1. 1111");
        given(subjectService.getSubjectTruncated(1L)).willReturn(subject);

        Item item = new Item();
        item.setId(1L);
        item.setInventoryNumber("IT001");
        item.setName("Some item");
        item.setCategory("/other items/other");
        item.setDefaultPhoto(null);
        item.setStatus(ItemStatus.DEPOSITED);
        given(itemService.getItemsTruncated(Collections.singleton(1L))).willReturn(Collections.singleton(item));

        Acquisition acquisition = acquisitionService.getAcquisition(1L);

        assertNotNull(acquisition);
        assertEquals(1L, acquisition.getId());
        assertEquals(AcquisitionType.PURCHASE, acquisition.getAcquisitionType());
        assertEquals("1. 1. 1111", acquisition.getAcquisitionDate());
        assertEquals(subject, acquisition.getAcquiredFrom());
        assertEquals(1, acquisition.getAcquiredItems().size());
        assertNull(acquisition.getDefaultGallery());
        assertEquals("1st acquisition", acquisition.getDescription());
        assertNull(acquisition.getComments());
    }

    @Test
    public void testSaveAcquisition() {
        Subject subject = new Person(1L, null, null, null, null, null, null, null, null, null, null, "Jiří", "Jan", "Mahdal", "1. 1. 1111");

        Item item = new Item();
        item.setId(1L);
        item.setInventoryNumber("IT001");
        item.setName("Some item");
        item.setCategory("/other items/other");
        item.setDefaultPhoto(null);
        item.setStatus(ItemStatus.DEPOSITED);

        Acquisition acquisition = new Acquisition(1L, AcquisitionType.PURCHASE, "1. 1. 1111", subject, Collections.singleton(item), null, null, null, null, null, null, "1st acquisition", null);

        ArgumentCaptor<DAcquisition> dAcquisitionArgumentCaptor = ArgumentCaptor.forClass(DAcquisition.class);

        acquisitionService.saveAcquisition(acquisition);

        then(acquisitionRepository).should().save(dAcquisitionArgumentCaptor.capture());

        DAcquisition dAcquisition = dAcquisitionArgumentCaptor.getValue();
        assertNotNull(dAcquisition);
        assertEquals(acquisition.getId(), dAcquisition.getId());
        assertEquals(acquisition.getAcquisitionType(), dAcquisition.getAcquisitionType());
        assertEquals(acquisition.getAcquisitionDate(), dAcquisition.getAcquisitionDate());
        assertEquals(acquisition.getAcquiredFrom().getId(), dAcquisition.getAcquiredFrom());
        assertEquals(acquisition.getAcquiredItems().size(), dAcquisition.getAcquiredItems().size());
        assertEquals(acquisition.getComments(), dAcquisition.getComments());
        assertEquals(acquisition.getComments(), dAcquisition.getComments());
    }

    @Test
    public void testGetAcquisitionTruncated() throws DBObjectNotFoundException {
        given(acquisitionRepository.findById(1L)).willReturn(Optional.of(new DAcquisition(1L, AcquisitionType.PURCHASE, "1. 1. 1111", 1L, Collections.singleton(1L), null, null, null, null, null, null, "1st acquisition", null)));

        Subject subject = new Person(1L, null, null, null, null, null, null, null, null, null, null, "Jiří", "Jan", "Mahdal", "1. 1. 1111");
        given(subjectService.getSubjectTruncated(1L)).willReturn(subject);

        Item item = new Item();
        item.setId(1L);
        item.setInventoryNumber("IT001");
        item.setName("Some item");
        item.setCategory("/other items/other");
        item.setDefaultPhoto(null);
        item.setStatus(ItemStatus.DEPOSITED);
        given(itemService.getItemsTruncated(Collections.singleton(1L))).willReturn(Collections.singleton(item));

        Acquisition acquisition = acquisitionService.getAcquisitionTruncated(1L);

        assertNotNull(acquisition);
        assertEquals(1L, acquisition.getId());
        assertEquals(AcquisitionType.PURCHASE, acquisition.getAcquisitionType());
        assertEquals("1. 1. 1111", acquisition.getAcquisitionDate());
        assertEquals(subject, acquisition.getAcquiredFrom());
        assertNull(acquisition.getAcquiredItems());
        assertNull(acquisition.getDefaultGallery());
        assertNull(acquisition.getDescription());
        assertNull(acquisition.getComments());
    }

    @Test
    public void testGetAcquisitionsTruncatedOneNotFound() {
        given(acquisitionRepository.findById(1L)).willReturn(Optional.of(new DAcquisition(1L, AcquisitionType.PURCHASE, "1. 1. 1111", null, null, null, null, null, null, null, null, null, null)));
        given(acquisitionRepository.findById(2L)).willReturn(Optional.empty());

        Set<Acquisition> acquisitions = acquisitionService.getAcquisitionsTruncated(new HashSet<>(Arrays.asList(1L, 2L)));
        assertEquals(1, acquisitions.size());
    }
}
