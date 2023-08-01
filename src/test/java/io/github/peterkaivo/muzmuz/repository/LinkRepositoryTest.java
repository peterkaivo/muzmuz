package io.github.peterkaivo.muzmuz.repository;

import io.github.peterkaivo.muzmuz.common.types.MediaType;
import io.github.peterkaivo.muzmuz.repository.model.DLink;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class LinkRepositoryTest {

    @Autowired
    private LinkRepository linkRepository;

    @Test
    public void testRead() {
        DLink dLink = linkRepository.findById(2L).orElse(null);
        assertNotNull(dLink);
        assertEquals(MediaType.LINK, dLink.getType());
        assertEquals("Thomann e-shop", dLink.getName());
        assertNull(dLink.getFileName());
        assertEquals("https://www.thomann.de/intl/index.html", dLink.getUrl());
        assertEquals("Link to e-shop of the biggest music shop in Europe", dLink.getDescription());
        assertNull(dLink.getComments());
    }

    @Test
    public void testReadAll() {
        List<DLink> allLinks = (List<DLink>) linkRepository.findAll();
        assertNotNull(allLinks);
        assertEquals(2, allLinks.size());
    }

    @Test
    public void testCRUD() {
        DLink dLink1 = new DLink(null, "Unique Stroh (horn) violin from Romania", null,
                "An ebay auction of an interesting violinophone, probably from Bihor, Romania",
                null, "https://www.ebay.com/itm/235065453773");
        DLink dLink2 = linkRepository.save(dLink1);

        DLink dLink3 = linkRepository.findById(dLink2.getId()).orElse(null);
        assertNotNull(dLink3);
        assertEquals(MediaType.LINK, dLink3.getType());
        assertEquals("Unique Stroh (horn) violin from Romania", dLink3.getName());
        assertNull(dLink3.getFileName());
        assertEquals("https://www.ebay.com/itm/235065453773", dLink3.getUrl());
        assertEquals("An ebay auction of an interesting violinophone, probably from Bihor, Romania", dLink3.getDescription());
        assertNull(dLink3.getComments());

        dLink3.setFileName("stroviol_ebay_backup.zip");
        dLink3.setComments("Auction ended, backup of the web page taken 29. 6. 2023");
        linkRepository.save(dLink3);

        DLink dLink4 = linkRepository.findById(dLink2.getId()).orElse(null);
        assertNotNull(dLink4);
        assertEquals("stroviol_ebay_backup.zip", dLink4.getFileName());
        assertEquals("Auction ended, backup of the web page taken 29. 6. 2023", dLink4.getComments());

        linkRepository.deleteById(dLink4.getId());

        DLink dLink5 = linkRepository.findById(dLink2.getId()).orElse(null);
        assertNull(dLink5);
    }
}
