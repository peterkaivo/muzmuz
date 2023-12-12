package io.github.peterkaivo.muzmuz.service;

import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundException;
import io.github.peterkaivo.muzmuz.service.model.Material;

import java.util.List;
import java.util.Set;

/**
 * Service class handling {@link io.github.peterkaivo.muzmuz.service.model.Material}
 */
public interface MaterialService {
    public List<Material> getAllMaterials();
    public Material getMaterial(Long id) throws DBObjectNotFoundException;
    public Material saveMaterial(Material material);
    public Set<Material> getMaterials(Set<Long> ids);
}
