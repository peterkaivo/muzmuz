package io.github.peterkaivo.muzmuz.service.impl;

import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundException;
import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundExceptionSupplier;
import io.github.peterkaivo.muzmuz.repository.DimensionRepository;
import io.github.peterkaivo.muzmuz.repository.model.DDimension;
import io.github.peterkaivo.muzmuz.service.DimensionService;
import io.github.peterkaivo.muzmuz.service.model.Dimension;
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
public class DimensionServiceImpl implements DimensionService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DimensionService.class);

    @Autowired
    private DimensionRepository dimensionRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Dimension> getAllDimensions() {
        List<DDimension> dimensions = (List<DDimension>) dimensionRepository.findAll();
        return dimensions.stream().map(this::fromDDimension).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Dimension getDimension(Long id) throws DBObjectNotFoundException {
        DDimension dimension = dimensionRepository.findById(id).orElseThrow(new DBObjectNotFoundExceptionSupplier(DDimension.class, id));
        return fromDDimension(dimension);
    }

    @Override
    public Dimension saveDimension(Dimension dimension) {
        dimensionRepository.save(toDDimension(dimension));
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Set<Dimension> getDimensions(Set<Long> ids) {
        Set<Dimension> dimensionSet = new HashSet<>();

        for (Long id : ids) {
            try {
                dimensionSet.add(getDimension(id));
            } catch (DBObjectNotFoundException e) {
                LOGGER.warn("getDimensions() - DB inconsistency found for DDimension with ID = {}", id);
                LOGGER.info(e.getMessage());
            }
        }

        return dimensionSet.isEmpty() ? null : dimensionSet;
    }

    private Dimension fromDDimension(DDimension dDimension) {
        Dimension dimension = new Dimension();
        dimension.setId(dDimension.getId());
        dimension.setDimensionType(dDimension.getDimensionType());
        dimension.setDimensionValue(dDimension.getDimensionValue());
        dimension.setUnit(dDimension.getUnit());
        dimension.setDescription(dDimension.getDescription());
        dimension.setComments(dDimension.getComments());

        return dimension;
    }

    private DDimension toDDimension(Dimension dimension) {
        DDimension dDimension = new DDimension();
        dDimension.setId(dimension.getId());
        dDimension.setDimensionType(dimension.getDimensionType());
        dDimension.setDimensionValue(dimension.getDimensionValue());
        dDimension.setUnit(dimension.getUnit());
        dDimension.setDescription(dimension.getDescription());
        dDimension.setComments(dimension.getComments());

        return dDimension;
    }
}
