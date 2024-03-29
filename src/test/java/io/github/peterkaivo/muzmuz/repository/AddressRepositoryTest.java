package io.github.peterkaivo.muzmuz.repository;

import io.github.peterkaivo.muzmuz.repository.model.DAddress;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AddressRepositoryTest {

    @Autowired
    private AddressRepository addressRepository;

    @Test
    public void testRead() {
        DAddress dAddress = addressRepository.findById(2L).orElse(null);
        assertNotNull(dAddress);
        assertEquals("Karmelitska 2/4", dAddress.getStreet1());
        assertNull(dAddress.getStreet2());
        assertEquals("Prague", dAddress.getCity());
        assertEquals("118 00", dAddress.getZip());
        assertEquals("Prague D.C.", dAddress.getProvince());
        assertEquals("Czech Republic", dAddress.getCountry());
        assertEquals("+420224497707", dAddress.getTelephone());
        assertEquals("cmh@nm.cz", dAddress.getEmail());
    }

    @Test
    public void testReadAll() {
        List<DAddress> allAddresses = (List<DAddress>) addressRepository.findAll();
        assertNotNull(allAddresses);
        assertEquals(3, allAddresses.size());
    }

    @Test
    public void testCRUD() {
        DAddress dAddress1 = new DAddress(null, "No. 1 Piazza Roma", null, "Cremona", "26100",
                "Lombardia", "Italia", null, null);
        DAddress dAddress2 = addressRepository.save(dAddress1);

        DAddress dAddress3 = addressRepository.findById(dAddress2.getId()).orElse(null);
        assertNotNull(dAddress3);
        assertEquals("No. 1 Piazza Roma", dAddress3.getStreet1());
        assertNull(dAddress3.getStreet2());
        assertEquals("Cremona", dAddress3.getCity());
        assertEquals("26100", dAddress3.getZip());
        assertEquals("Lombardia", dAddress3.getProvince());
        assertEquals("Italia", dAddress3.getCountry());
        assertNull(dAddress3.getTelephone());
        assertNull(dAddress3.getEmail());

        dAddress3.setStreet1("No. 2 Piazza San Domenico");
        dAddress3.setCountry("Ducato di Milano");
        addressRepository.save(dAddress3);

        DAddress dAddress4 = addressRepository.findById(dAddress2.getId()).orElse(null);
        assertNotNull(dAddress4);
        assertEquals("No. 2 Piazza San Domenico", dAddress4.getStreet1());
        assertEquals("Ducato di Milano", dAddress4.getCountry());

        addressRepository.deleteById(dAddress4.getId());

        DAddress dAddress5 = addressRepository.findById(dAddress2.getId()).orElse(null);
        assertNull(dAddress5);
    }
}
