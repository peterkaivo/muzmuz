package io.github.peterkaivo.muzmuz.dataservice;

import io.github.peterkaivo.muzmuz.dataservice.model.DGraphics;
import org.springframework.data.repository.CrudRepository;

/**
 * Data service interface for {@link DGraphics} class
 */
public interface GraphicsDataService extends CrudRepository<DGraphics, Long> {
}
