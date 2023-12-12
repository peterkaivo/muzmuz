package io.github.peterkaivo.muzmuz.service;

import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundException;
import io.github.peterkaivo.muzmuz.service.model.Graphics;

import java.util.List;
import java.util.Set;

/**
 * Service class handling {@link io.github.peterkaivo.muzmuz.service.model.Graphics}
 */
public interface GraphicsService {
    public List<Graphics> getAllGraphics();
    public Graphics getGraphics(Long id) throws DBObjectNotFoundException;
    public Set<Graphics> getGraphicsSet(Set<Long> ids);
    public Graphics saveGraphics(Graphics graphics);
}
