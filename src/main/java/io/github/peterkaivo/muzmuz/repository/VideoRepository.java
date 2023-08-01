package io.github.peterkaivo.muzmuz.repository;

import io.github.peterkaivo.muzmuz.repository.model.DVideo;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for {@link DVideo} class
 */
public interface VideoRepository extends CrudRepository<DVideo, Long> {
}
