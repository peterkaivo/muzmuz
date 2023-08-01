package io.github.peterkaivo.muzmuz.repository;

import io.github.peterkaivo.muzmuz.repository.model.DImageGallery;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for {@link DImageGallery} class
 */
public interface ImageGalleryRepository extends CrudRepository<DImageGallery, Long> {
}
