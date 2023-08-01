package io.github.peterkaivo.muzmuz.service;

import io.github.peterkaivo.muzmuz.common.exceptions.ItemNotFoundException;
import io.github.peterkaivo.muzmuz.service.model.Graphics;

import java.util.List;

/**
 * Service class handling {@link io.github.peterkaivo.muzmuz.service.model.Graphics}
 */
public interface GraphicsService {
    public List<Graphics> getAllGraphics();
    public Graphics getGraphics(Long id) throws ItemNotFoundException;
    public Graphics saveGraphics(Graphics acquisition);
}
