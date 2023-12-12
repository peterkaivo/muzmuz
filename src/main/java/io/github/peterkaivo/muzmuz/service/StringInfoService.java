package io.github.peterkaivo.muzmuz.service;

import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundException;
import io.github.peterkaivo.muzmuz.service.model.StringInfo;

import java.util.List;

/**
 * Service class handling {@link io.github.peterkaivo.muzmuz.service.model.StringInfo}
 */
public interface StringInfoService {
    public List<StringInfo> getAllStringInfos();
    public StringInfo getStringInfo(Long id) throws DBObjectNotFoundException;
    public List<StringInfo> getStringInfos(List<Long> ids);
    public StringInfo saveStringInfo(StringInfo stringInfo);
}
