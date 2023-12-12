package io.github.peterkaivo.muzmuz.service.impl;

import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundException;
import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundExceptionSupplier;
import io.github.peterkaivo.muzmuz.repository.StringInfoRepository;
import io.github.peterkaivo.muzmuz.repository.model.DStringInfo;
import io.github.peterkaivo.muzmuz.service.DimensionService;
import io.github.peterkaivo.muzmuz.service.MaterialService;
import io.github.peterkaivo.muzmuz.service.StringInfoService;
import io.github.peterkaivo.muzmuz.service.model.StringInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StringInfoServiceImpl implements StringInfoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(StringInfoService.class);

    @Autowired
    StringInfoRepository stringInfoRepository;

    @Autowired
    DimensionService dimensionService;

    @Autowired
    MaterialService materialService;

    @Override
    @Transactional(readOnly = true)
    public List<StringInfo> getAllStringInfos() {
        List<DStringInfo> stringInfoList = (List<DStringInfo>) stringInfoRepository.findAll();

        return stringInfoList.stream().map(this::fromDStringInfo).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public StringInfo getStringInfo(Long id) throws DBObjectNotFoundException {
        DStringInfo dStringInfo = stringInfoRepository.findById(id).orElseThrow(new DBObjectNotFoundExceptionSupplier(DStringInfo.class, id));

        return fromDStringInfo(dStringInfo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<StringInfo> getStringInfos(List<Long> ids) {
        List<StringInfo> stringInfoList = new ArrayList<>();

        for (Long id : ids) {
            try {
                stringInfoList.add(getStringInfo(id));
            } catch (DBObjectNotFoundException e) {
                LOGGER.warn("getStringInfos() - DB inconsistency found for DStringInfo with ID = {}", id);
                LOGGER.info(e.getMessage());
            }
        }

        return stringInfoList;
    }

    @Override
    public StringInfo saveStringInfo(StringInfo stringInfo) {
        stringInfoRepository.save(toDStringInfo(stringInfo));

        return stringInfo;
    }

    private StringInfo fromDStringInfo(DStringInfo dStringInfo) {
        StringInfo stringInfo = new StringInfo();
        stringInfo.setId(dStringInfo.getId());
        stringInfo.setStringOrder(dStringInfo.getStringOrder());
        stringInfo.setPitch(dStringInfo.getPitch());
        try {
            stringInfo.setThickness(dStringInfo.getThickness() == null ? null : dimensionService.getDimension(dStringInfo.getThickness()));
        } catch (DBObjectNotFoundException e) {
            LOGGER.warn("fromDStringInfo() - DB inconsistency found for DStringInfo with ID = {}", dStringInfo.getId());
            LOGGER.info(e.getMessage());
        }
        try {
            stringInfo.setMaterial(dStringInfo.getMaterial() == null ? null : materialService.getMaterial(dStringInfo.getMaterial()));
        } catch (DBObjectNotFoundException e) {
            LOGGER.warn("fromDStringInfo() - DB inconsistency found for DStringInfo with ID = {}", dStringInfo.getId());
            LOGGER.info(e.getMessage());
        }
        stringInfo.setDescription(dStringInfo.getDescription());
        stringInfo.setComments(dStringInfo.getComments());

        return stringInfo;
    }

    private DStringInfo toDStringInfo(StringInfo stringInfo) {
        DStringInfo dStringInfo = new DStringInfo();
        dStringInfo.setId(stringInfo.getId());
        dStringInfo.setStringOrder(stringInfo.getStringOrder());
        dStringInfo.setPitch(stringInfo.getPitch());
        dStringInfo.setThickness(stringInfo.getThickness() == null ? null : stringInfo.getThickness().getId());
        dStringInfo.setMaterial(stringInfo.getMaterial() == null ? null : stringInfo.getMaterial().getId());
        dStringInfo.setDescription(stringInfo.getDescription());
        dStringInfo.setComments(stringInfo.getComments());

        return dStringInfo;
    }
}
