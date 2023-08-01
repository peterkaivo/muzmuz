package io.github.peterkaivo.muzmuz.service;

import io.github.peterkaivo.muzmuz.common.exceptions.ItemNotFoundException;
import io.github.peterkaivo.muzmuz.service.model.StringInfo;

import java.util.List;

/**
 * Service class handling {@link io.github.peterkaivo.muzmuz.service.model.StringInfo}
 */
public interface StringInfoService {
    public List<StringInfo> getAllStringInfos();
    public StringInfo getStringInfo(Long id) throws ItemNotFoundException;
    public StringInfo saveStringInfo(StringInfo acquisition);
}
