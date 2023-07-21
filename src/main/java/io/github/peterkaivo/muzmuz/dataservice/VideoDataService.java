package io.github.peterkaivo.muzmuz.dataservice;

import io.github.peterkaivo.muzmuz.dataservice.model.DVideo;
import org.springframework.data.repository.CrudRepository;

/**
 * Data service interface for {@link DVideo} class
 */
public interface VideoDataService extends CrudRepository<DVideo, Long> {
}
