package io.github.peterkaivo.muzmuz.dataservice;

import io.github.peterkaivo.muzmuz.dataservice.model.DImageGallery;
import org.springframework.data.repository.CrudRepository;

/**
 * Data service interface for {@link DImageGallery} class
 */
public interface ImageGalleryDataService extends CrudRepository<DImageGallery, Long> {
}
