package io.github.peterkaivo.muzmuz.service;

import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundException;
import io.github.peterkaivo.muzmuz.common.types.DimensionType;
import io.github.peterkaivo.muzmuz.common.types.ItemStatus;
import io.github.peterkaivo.muzmuz.common.types.MaterialCategory;
import io.github.peterkaivo.muzmuz.common.types.Unit;
import io.github.peterkaivo.muzmuz.repository.AccessoryRepository;
import io.github.peterkaivo.muzmuz.repository.model.DAccessory;
import io.github.peterkaivo.muzmuz.service.model.*;
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
public class AccessoryServiceTest {
    @Autowired
    private AccessoryService accessoryService;
    @MockBean
    private AccessoryRepository accessoryRepository;
    @MockBean
    private ImageGalleryService imageGalleryService;
    @MockBean
    private LocationService locationService;
    @MockBean
    private DimensionService dimensionService;
    @MockBean
    private MaterialService materialService;

    @Test
    public void testGetAllAccessories() {
        given(accessoryRepository.findAll()).willAnswer(invocation -> Arrays.asList(
                new DAccessory(1L, "Acc001", "Accessory1", null, null, null, ItemStatus.DEPOSITED, 1L, null, null, "1st accessory", null),
                new DAccessory(2L, "Acc002", "Accessory2", null, null, null, ItemStatus.DEPOSITED, 2L, null, null, "2nd accessory", null)
        ));

        List<Accessory> accessories = accessoryService.getAllAccessories();

        assertNotNull(accessories);
        assertEquals(2, accessories.size());
    }

    @Test
    public void testGetAccessory() throws DBObjectNotFoundException {
        given(accessoryRepository.findById(1L)).willReturn(Optional.of(new DAccessory(1L, "Acc001", "Accessory1", "AddName1", 1L, 1L, ItemStatus.EXPOSED, 1L, Collections.singleton(1L), Collections.singleton(1L), "1st accessory", null)));

        Photo defaultPhoto = new Photo(1L, "DefaultPhoto", "default.jpg", "Default photo", null, "1024x768", "1. 1. 1111");
        ImageGallery imageGallery = new ImageGallery(1L, "Default gallery", Collections.singleton(defaultPhoto), "Default gallery", null);
        Location location = new Location(1L, "Default location", null, null, null);
        Dimension dimension = new Dimension(1L, DimensionType.LENGTH, 14.5f, Unit.CM, "Total length", "Too small");
        Set<Dimension> dimensions = Collections.singleton(dimension);
        Material material = new Material(1L, MaterialCategory.LEATHER, "Some skin", "Too skinny", null);
        Set<Material> materials = Collections.singleton(material);

        given(imageGalleryService.getImageGallery(1L)).willReturn(imageGallery);
        given(locationService.getLocationTruncated(1L)).willReturn(location);
        given(dimensionService.getDimensions(Collections.singleton(1L))).willReturn(dimensions);
        given(materialService.getMaterials(Collections.singleton(1L))).willReturn(materials);

        Accessory accessory = accessoryService.getAccessory(1L);

        assertNotNull(accessory);
        assertEquals(1L, accessory.getId());
        assertEquals("Acc001", accessory.getInventoryNumber());
        assertEquals("Accessory1", accessory.getName());
        assertEquals("AddName1", accessory.getAdditionalName());
        assertEquals(defaultPhoto, accessory.getDefaultPhoto());
        assertEquals(imageGallery, accessory.getDefaultGallery());
        assertEquals(ItemStatus.EXPOSED, accessory.getStatus());
        assertEquals(location, accessory.getLocation());
        assertTrue(accessory.getDimensions().contains(dimension));
        assertTrue(accessory.getMaterial().contains(material));
        assertEquals("1st accessory", accessory.getDescription());
        assertNull(accessory.getComments());
    }
/*
    @Test
    public void testSaveAccessory() {
        Subject subject = new Person(1L, null, null, null, null, null, null, null, null, null, null, "Jiří", "Jan", "Mahdal", "1. 1. 1111");

        Item item = new Item();
        item.setId(1L);
        item.setInventoryNumber("IT001");
        item.setName("Some item");
        item.setCategory("/other items/other");
        item.setDefaultPhoto(null);
        item.setStatus(ItemStatus.DEPOSITED);

        Accessory accessory = new Accessory(1L, AccessoryType.PURCHASE, "1. 1. 1111", subject, Collections.singleton(item), null, null, null, null, null, null, "1st accessory", null);

        ArgumentCaptor<DAccessory> dAccessoryArgumentCaptor = ArgumentCaptor.forClass(DAccessory.class);

        accessoryService.saveAccessory(accessory);

        then(accessoryRepository).should().save(dAccessoryArgumentCaptor.capture());

        DAccessory dAccessory = dAccessoryArgumentCaptor.getValue();
        assertNotNull(dAccessory);
        assertEquals(accessory.getId(), dAccessory.getId());
        assertEquals(accessory.getAccessoryType(), dAccessory.getAccessoryType());
        assertEquals(accessory.getAccessoryDate(), dAccessory.getAccessoryDate());
        assertEquals(accessory.getAcquiredFrom().getId(), dAccessory.getAcquiredFrom());
        assertEquals(accessory.getAcquiredItems().size(), dAccessory.getAcquiredItems().size());
        assertEquals(accessory.getComments(), dAccessory.getComments());
        assertEquals(accessory.getComments(), dAccessory.getComments());
    }

    @Test
    public void testGetAccessoryTruncated() throws DBObjectNotFoundException {
        given(accessoryRepository.findById(1L)).willReturn(Optional.of(new DAccessory(1L, AccessoryType.PURCHASE, "1. 1. 1111", 1L, Collections.singleton(1L), null, null, null, null, null, null, "1st accessory", null)));

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

        Accessory accessory = accessoryService.getAccessoryTruncated(1L);

        assertNotNull(accessory);
        assertEquals(1L, accessory.getId());
        assertEquals(AccessoryType.PURCHASE, accessory.getAccessoryType());
        assertEquals("1. 1. 1111", accessory.getAccessoryDate());
        assertEquals(subject, accessory.getAcquiredFrom());
        assertNull(accessory.getAcquiredItems());
        assertNull(accessory.getDefaultGallery());
        assertNull(accessory.getDescription());
        assertNull(accessory.getComments());
    }

    @Test
    public void testGetAccessorysTruncatedOneNotFound() {
        given(accessoryRepository.findById(1L)).willReturn(Optional.of(new DAccessory(1L, AccessoryType.PURCHASE, "1. 1. 1111", null, null, null, null, null, null, null, null, null, null)));
        given(accessoryRepository.findById(2L)).willReturn(Optional.empty());

        Set<Accessory> accessorys = accessoryService.getAccessorysTruncated(new HashSet<>(Arrays.asList(1L, 2L)));
        assertEquals(1, accessorys.size());
    }*/
}
