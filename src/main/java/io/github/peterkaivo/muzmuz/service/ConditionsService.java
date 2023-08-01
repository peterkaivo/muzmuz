package io.github.peterkaivo.muzmuz.service;

import io.github.peterkaivo.muzmuz.common.exceptions.ItemNotFoundException;
import io.github.peterkaivo.muzmuz.service.model.Conditions;

import java.util.List;

/**
 * Service class handling {@link io.github.peterkaivo.muzmuz.service.model.Conditions}
 */
public interface ConditionsService {
    public List<Conditions> getAllConditions();
    public Conditions getConditions(Long id) throws ItemNotFoundException;
    public Conditions saveConditions(Conditions acquisition);
}
