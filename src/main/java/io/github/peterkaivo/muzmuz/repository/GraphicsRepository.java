package io.github.peterkaivo.muzmuz.repository;

import io.github.peterkaivo.muzmuz.repository.model.DGraphics;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for {@link DGraphics} class
 */
public interface GraphicsRepository extends CrudRepository<DGraphics, Long> {
}
