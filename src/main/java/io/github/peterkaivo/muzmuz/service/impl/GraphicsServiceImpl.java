package io.github.peterkaivo.muzmuz.service.impl;

import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundException;
import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundExceptionSupplier;
import io.github.peterkaivo.muzmuz.repository.GraphicsRepository;
import io.github.peterkaivo.muzmuz.repository.model.DDrawing;
import io.github.peterkaivo.muzmuz.repository.model.DGraphics;
import io.github.peterkaivo.muzmuz.repository.model.DImage;
import io.github.peterkaivo.muzmuz.repository.model.DPhoto;
import io.github.peterkaivo.muzmuz.service.GraphicsService;
import io.github.peterkaivo.muzmuz.service.model.Drawing;
import io.github.peterkaivo.muzmuz.service.model.Graphics;
import io.github.peterkaivo.muzmuz.service.model.Image;
import io.github.peterkaivo.muzmuz.service.model.Photo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class GraphicsServiceImpl implements GraphicsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(GraphicsService.class);

    @Autowired
    GraphicsRepository graphicsRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Graphics> getAllGraphics() {
        List<DGraphics> dGraphicsList = (List<DGraphics>) graphicsRepository.findAll();
        List<Graphics> graphicsList = new ArrayList<>();

        for (DGraphics dGraphics : dGraphicsList) {
            switch (dGraphics.getType()) {
                case DRAWING -> graphicsList.add(fromDGraphics(dGraphics, new Drawing()));
                case IMAGE -> graphicsList.add(fromDGraphics(dGraphics, new Image()));
                case PHOTO -> graphicsList.add(fromDGraphics(dGraphics, new Photo()));
                default -> LOGGER.trace("getAllGraphics() - Unsupported MediaType of DGraphics with ID = {}", dGraphics.getId());
            }
        }

        return graphicsList;
    }

    @Override
    @Transactional(readOnly = true)
    public Graphics getGraphics(Long id) throws DBObjectNotFoundException {
        DGraphics dGraphics = graphicsRepository.findById(id).orElseThrow(new DBObjectNotFoundExceptionSupplier(DGraphics.class, id));

        return switch (dGraphics.getType()) {
            case DRAWING -> fromDGraphics(dGraphics, new Drawing());
            case IMAGE -> fromDGraphics(dGraphics, new Image());
            case PHOTO -> fromDGraphics(dGraphics, new Photo());
            default -> null;
        };
    }

    @Override
    @Transactional(readOnly = true)
    public Set<Graphics> getGraphicsSet(Set<Long> ids) {
        Set<Graphics> graphicsSet = new HashSet<>();

        for (Long id : ids) {
            try {
                graphicsSet.add(getGraphics(id));
            } catch (DBObjectNotFoundException e) {
                LOGGER.warn("getGraphicsSet() - DB inconsistency found for DGraphics with ID = {}", id);
                LOGGER.info(e.getMessage());
            }
        }

        return graphicsSet;
    }

    @Override
    public Graphics saveGraphics(Graphics graphics) {
        switch (graphics.getType()) {
            case DRAWING -> graphicsRepository.save(toDGraphics(graphics, new DDrawing()));
            case IMAGE -> graphicsRepository.save(toDGraphics(graphics, new DImage()));
            case PHOTO -> graphicsRepository.save(toDGraphics(graphics, new DPhoto()));
            default -> LOGGER.warn("saveSubject() - Unsupported MediaType of Graphics with ID = {}", graphics.getId());
        }

        return graphics;
    }

    private Graphics fromDGraphics(DGraphics dGraphics, Graphics graphics) {
        graphics.setId(dGraphics.getId());
        graphics.setName(dGraphics.getName());
        graphics.setFileName(dGraphics.getFileName());
        graphics.setDescription(dGraphics.getDescription());
        graphics.setComments(dGraphics.getComments());
        graphics.setResolution(dGraphics.getResolution());
        graphics.setAcquired(dGraphics.getAcquired());

        return graphics;
    }

    private DGraphics toDGraphics(Graphics graphics, DGraphics dGraphics) {
        dGraphics.setId(graphics.getId());
        dGraphics.setName(graphics.getName());
        dGraphics.setFileName(graphics.getFileName());
        dGraphics.setDescription(graphics.getDescription());
        dGraphics.setComments(graphics.getComments());
        dGraphics.setResolution(graphics.getResolution());
        dGraphics.setAcquired(graphics.getAcquired());

        return dGraphics;
    }
}
