package io.github.peterkaivo.muzmuz.service.impl;

import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundException;
import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundExceptionSupplier;
import io.github.peterkaivo.muzmuz.repository.ConditionsRepository;
import io.github.peterkaivo.muzmuz.repository.model.DConditions;
import io.github.peterkaivo.muzmuz.service.ConditionsService;
import io.github.peterkaivo.muzmuz.service.model.Audio;
import io.github.peterkaivo.muzmuz.service.model.Conditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional

public class ConditionsServiceImpl implements ConditionsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConditionsService.class);

    @Autowired
    ConditionsRepository conditionsRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Conditions> getAllConditions() {
        List<DConditions> conditions = (List<DConditions>) conditionsRepository.findAll();
        return conditions.stream().map(this::fromDConditions).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Conditions getConditions(Long id) throws DBObjectNotFoundException {
        DConditions conditions = conditionsRepository.findById(id).orElseThrow(new DBObjectNotFoundExceptionSupplier(DConditions.class, id));
        return fromDConditions(conditions);
    }

    @Override
    @Transactional(readOnly = true)
    public Set<Conditions> getConditionsSet(Set<Long> ids) {
        Set<Conditions> conditionsSet = new HashSet<>();

        for (Long id : ids) {
            try {
                conditionsSet.add(getConditions(id));
            } catch (DBObjectNotFoundException e) {
                LOGGER.warn("getConditionsSet() - DB inconsistency found for DConditions with ID = {}", id);
                LOGGER.info(e.getMessage());
            }
        }

        return conditionsSet.isEmpty() ? null : conditionsSet;
    }

    @Override
    public Conditions saveConditions(Conditions conditions) {
        conditionsRepository.save(toDConditions(conditions));
        return conditions;
    }

    private Conditions fromDConditions(DConditions dConditions) {
        Conditions conditions = new Conditions();
        conditions.setId(dConditions.getId());
        conditions.setConditionStatus(dConditions.getConditionStatus());
        conditions.setCompactness(dConditions.getCompactness());
        conditions.setDescription(dConditions.getDescription());
        conditions.setComments(dConditions.getComments());

        return conditions;
    }

    private DConditions toDConditions(Conditions conditions) {
        DConditions dConditions = new DConditions();
        dConditions.setId(conditions.getId());
        dConditions.setConditionStatus(conditions.getConditionStatus());
        dConditions.setCompactness(conditions.getCompactness());
        dConditions.setDescription(conditions.getDescription());
        dConditions.setComments(conditions.getComments());

        return dConditions;
    }
}
