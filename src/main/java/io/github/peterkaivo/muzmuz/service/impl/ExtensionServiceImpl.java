package io.github.peterkaivo.muzmuz.service.impl;

import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundException;
import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundExceptionSupplier;
import io.github.peterkaivo.muzmuz.repository.ExtensionRepository;
import io.github.peterkaivo.muzmuz.repository.model.*;
import io.github.peterkaivo.muzmuz.service.ExtensionService;
import io.github.peterkaivo.muzmuz.service.GraphicsService;
import io.github.peterkaivo.muzmuz.service.StringInfoService;
import io.github.peterkaivo.muzmuz.service.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class ExtensionServiceImpl implements ExtensionService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExtensionService.class);
    private static final String DSTRINGS = "DStrings";

    @Autowired
    ExtensionRepository extensionRepository;
    @Autowired
    StringInfoService stringInfoService;
    @Autowired
    GraphicsService graphicsService;

    @Override
    @Transactional(readOnly = true)
    public List<Extension> getAllExtensions() {
        List<DExtension> dExtensions = (List<DExtension>) extensionRepository.findAll();
        List<Extension> extensions = new ArrayList<>();

        for (DExtension dExtension : dExtensions) {
            switch (dExtension.getClass().getSimpleName()) {
                case DSTRINGS -> extensions.add(fromDStrings((DStrings) dExtension));
                default -> LOGGER.trace("getAllExtensions() - Unsupported Extension type {} with ID = {}", dExtensions.getClass().getSimpleName(), dExtension.getId());
            }
        }

        return extensions;
    }

    @Override
    @Transactional(readOnly = true)
    public Extension getExtension(Long id) throws DBObjectNotFoundException {
        DExtension dExtension = extensionRepository.findById(id).orElseThrow(new DBObjectNotFoundExceptionSupplier(DExtension.class, id));

        return switch (dExtension.getClass().getSimpleName()) {
            case DSTRINGS -> fromDStrings((DStrings) dExtension);
            default -> null;
        };
    }

    @Override
    @Transactional(readOnly = true)
    public Set<Extension> getExtensions(Set<Long> ids) {
        Set<Extension> extensions = new HashSet<>();

        for (Long id : ids) {
            try {
                extensions.add(getExtension(id));
            } catch (DBObjectNotFoundException e) {
                LOGGER.warn("getExtensions() - DB inconsistency found for DExtension of with ID = {}", id);
                LOGGER.info(e.getMessage());
            }
        }

        return extensions.isEmpty() ? null : extensions;
    }

    @Override
    public Extension saveExtension(Extension extension) {
        switch (extension.getClass().getSimpleName()) {
            case DSTRINGS -> extensionRepository.save(toDStrings((Strings) extension));
            default -> LOGGER.warn("saveExtension() - Unsupported Extension type {} with ID = {}", extension.getClass().getSimpleName(), extension.getId());
        }
        return null;
    }

    private Strings fromDStrings(DStrings dStrings) {
        Strings strings = new Strings();
        strings.setId(dStrings.getId());
        strings.setName(dStrings.getName());
        strings.setTemplateName(dStrings.getTemplateName());
        strings.setDescription(dStrings.getDescription());
        strings.setComments(dStrings.getComments());
        strings.setStrings(dStrings.getStrings() == null ? Collections.emptyList() : stringInfoService.getStringInfos(dStrings.getStrings()));
        strings.setSchema(dStrings.getSchema() == null ? null : getDrawing(dStrings));

        return strings;
    }

    private Drawing getDrawing(DStrings dStrings) {
        Drawing drawing = null;

        if (dStrings.getId() != null) {
            try {
                Graphics graphics = graphicsService.getGraphics(dStrings.getId());
                if (Drawing.class.equals(graphics.getClass())) {
                    drawing = (Drawing) graphics;
                } else {
                    LOGGER.warn("getDrawing() - DB inconsistency found for DStrings with ID = {}: Schema (Drawing) with ID = {} is not Drawing but {}", dStrings.getId(), dStrings.getSchema(), graphics.getType().toString());
                }
            } catch (DBObjectNotFoundException e) {
                LOGGER.warn("getDrawing() - DB inconsistency found for DStrings with ID = {}: Schema (Drawing) with ID = {} not found", dStrings.getId(), dStrings.getSchema());
                LOGGER.info(e.getMessage());
            }
        }

        return drawing;
    }

    private DStrings toDStrings(Strings strings) {
        DStrings dStrings = new DStrings();
        dStrings.setId(strings.getId());
        dStrings.setName(strings.getName());
        dStrings.setTemplateName(strings.getTemplateName());
        dStrings.setDescription(strings.getDescription());
        dStrings.setComments(strings.getComments());
        dStrings.setStrings(strings.getStrings() == null ? null : strings.getStrings().stream().map(StringInfo::getId).collect(Collectors.toList()));
        dStrings.setSchema(strings.getSchema() == null ? null : strings.getSchema().getId());

        return dStrings;
    }
}
