package io.github.peterkaivo.muzmuz.dataservice;

import io.github.peterkaivo.muzmuz.common.types.MaterialCategory;
import io.github.peterkaivo.muzmuz.dataservice.model.DMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MaterialDataServiceTest {

    @Autowired
    private MaterialDataService materialDataService;

    @Test
    public void testRead() {
        DMaterial dMaterial = materialDataService.findById(2L).orElse(null);
        assertNotNull(dMaterial);
        assertEquals(MaterialCategory.METAL, dMaterial.getCategory());
        assertEquals("Heavy metal", dMaterial.getType());
        assertEquals("It's rather a death metal", dMaterial.getDescription());
        assertEquals("Death metal is not death!!!", dMaterial.getComments());
    }

    @Test
    public void testReadAll() {
        List<DMaterial> allMaterials = (List<DMaterial>) materialDataService.findAll();
        assertNotNull(allMaterials);
        assertEquals(2, allMaterials.size());
    }

    @Test
    public void testCRUD() {
        DMaterial dMaterial1 = new DMaterial(null, MaterialCategory.ORGANIC, "Goat skin", "Windbag", null);
        DMaterial dMaterial2 = materialDataService.save(dMaterial1);

        DMaterial dMaterial3 = materialDataService.findById(dMaterial2.getId()).orElse(null);
        assertNotNull(dMaterial3);
        assertEquals(MaterialCategory.ORGANIC, dMaterial3.getCategory());
        assertEquals("Goat skin", dMaterial3.getType());
        assertEquals("Windbag", dMaterial3.getDescription());
        assertNull(dMaterial3.getComments());

        dMaterial3.setCategory(MaterialCategory.LEATHER);
        dMaterial3.setComments("It starts moulting");
        materialDataService.save(dMaterial3);

        DMaterial dMaterial4 = materialDataService.findById(dMaterial2.getId()).orElse(null);
        assertNotNull(dMaterial4);
        assertEquals(MaterialCategory.LEATHER, dMaterial4.getCategory());
        assertEquals("It starts moulting", dMaterial4.getComments());

        materialDataService.deleteById(dMaterial4.getId());

        DMaterial dMaterial5 = materialDataService.findById(dMaterial2.getId()).orElse(null);
        assertNull(dMaterial5);
    }
}
