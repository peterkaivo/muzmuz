package io.github.peterkaivo.muzmuz.service;

import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundException;
import io.github.peterkaivo.muzmuz.service.model.Conditions;

import java.util.List;
import java.util.Set;

/**
 * Service class handling {@link io.github.peterkaivo.muzmuz.service.model.Conditions}
 */
public interface ConditionsService {
    public List<Conditions> getAllConditions();
    public Conditions getConditions(Long id) throws DBObjectNotFoundException;
    public Set<Conditions> getConditionsSet(Set<Long> ids);
    public Conditions saveConditions(Conditions conditions);
}
