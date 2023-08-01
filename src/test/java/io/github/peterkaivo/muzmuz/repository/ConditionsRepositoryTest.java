package io.github.peterkaivo.muzmuz.repository;

import io.github.peterkaivo.muzmuz.common.types.Compactness;
import io.github.peterkaivo.muzmuz.common.types.ConditionStatus;
import io.github.peterkaivo.muzmuz.repository.model.DConditions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ConditionsRepositoryTest {
    @Autowired
    ConditionsRepository conditionsRepository;

    @Test
    public void testRead() {
        DConditions dConditions = conditionsRepository.findById(2L).orElse(null);
        assertNotNull(dConditions);
        assertEquals(ConditionStatus.NEW, dConditions.getConditionStatus());
        assertEquals(Compactness.COMPLETE, dConditions.getCompactness());
        assertEquals("Funglovka", dConditions.getDescription());
        assertEquals("Luckily no transport damage", dConditions.getComments());
    }

    @Test
    public void testReadAll() {
        List<DConditions> allConditions = (List<DConditions>) conditionsRepository.findAll();
        assertNotNull(allConditions);
        assertEquals(2, allConditions.size());
    }

    @Test
    public void testCRUD() {
        DConditions dConditions1 = new DConditions(null, ConditionStatus.TRACES_OF_USE, Compactness.COMPLETE, "It was played", "That guy cannot play");
        DConditions dConditions2 = conditionsRepository.save(dConditions1);

        DConditions dConditions3 = conditionsRepository.findById(dConditions2.getId()).orElse(null);
        assertNotNull(dConditions3);
        assertEquals(ConditionStatus.TRACES_OF_USE, dConditions3.getConditionStatus());
        assertEquals(Compactness.COMPLETE, dConditions3.getCompactness());
        assertEquals("It was played", dConditions3.getDescription());
        assertEquals("That guy cannot play", dConditions3.getComments());

        dConditions3.setCompactness(Compactness.INCOMPLETE);
        dConditions3.setComments("I lost the plectrum");
        conditionsRepository.save(dConditions3);

        DConditions dConditions4 = conditionsRepository.findById(dConditions2.getId()).orElse(null);
        assertNotNull(dConditions4);
        assertEquals(Compactness.INCOMPLETE, dConditions4.getCompactness());
        assertEquals("I lost the plectrum", dConditions4.getComments());

        conditionsRepository.deleteById(dConditions4.getId());

        DConditions dConditions5 = conditionsRepository.findById(dConditions2.getId()).orElse(null);
        assertNull(dConditions5);
    }
}
