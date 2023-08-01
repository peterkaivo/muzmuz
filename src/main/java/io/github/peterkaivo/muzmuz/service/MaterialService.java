package io.github.peterkaivo.muzmuz.service;

import io.github.peterkaivo.muzmuz.common.exceptions.ItemNotFoundException;
import io.github.peterkaivo.muzmuz.service.model.Material;

import java.util.List;

/**
 * Service class handling {@link io.github.peterkaivo.muzmuz.service.model.Material}
 */
public interface MaterialService {
    public List<Material> getAllMaterials();
    public Material getMaterial(Long id) throws ItemNotFoundException;
    public Material saveMaterial(Material acquisition);
}
