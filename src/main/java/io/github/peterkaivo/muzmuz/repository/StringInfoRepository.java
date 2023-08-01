package io.github.peterkaivo.muzmuz.repository;

import io.github.peterkaivo.muzmuz.repository.model.DStringInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for {@link DStringInfo} class
 */
public interface StringInfoRepository extends CrudRepository<DStringInfo, Long> {
}
