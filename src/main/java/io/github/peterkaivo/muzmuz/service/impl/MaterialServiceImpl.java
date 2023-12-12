package io.github.peterkaivo.muzmuz.service.impl;

import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundException;
import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundExceptionSupplier;
import io.github.peterkaivo.muzmuz.repository.MaterialRepository;
import io.github.peterkaivo.muzmuz.repository.model.DMaterial;
import io.github.peterkaivo.muzmuz.service.MaterialService;
import io.github.peterkaivo.muzmuz.service.model.Material;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class MaterialServiceImpl implements MaterialService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MaterialService.class);

    @Autowired
    MaterialRepository materialRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Material> getAllMaterials() {
        List<DMaterial> materials = (List<DMaterial>) materialRepository.findAll();

        return materials.stream().map(this::fromDMaterial).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Material getMaterial(Long id) throws DBObjectNotFoundException {
        DMaterial dMaterial = materialRepository.findById(id).orElseThrow(new DBObjectNotFoundExceptionSupplier(DMaterial.class, id));

        return fromDMaterial(dMaterial);
    }

    @Override
    public Material saveMaterial(Material material) {
        materialRepository.save(toDMaterial(material));

        return material;
    }

    @Override
    @Transactional(readOnly = true)
    public Set<Material> getMaterials(Set<Long> ids) {
        Set<Material> materials = new HashSet<>();

        for (Long id : ids) {
            try {
                materials.add(getMaterial(id));
            } catch (DBObjectNotFoundException e) {
                LOGGER.warn("getMaterials() - DB inconsistency found for DMaterial with ID = {}", id);
                LOGGER.info(e.getMessage());
            }
        }

        return materials;
    }

    private Material fromDMaterial(DMaterial dMaterial) {
        Material material = new Material();
        material.setId(dMaterial.getId());
        material.setCategory(dMaterial.getCategory());
        material.setType(dMaterial.getType());
        material.setDescription(dMaterial.getDescription());
        material.setComments(dMaterial.getComments());

        return material;
    }

    private DMaterial toDMaterial(Material material) {
        DMaterial dMaterial = new DMaterial();
        dMaterial.setId(material.getId());
        dMaterial.setCategory(material.getCategory());
        dMaterial.setType(material.getType());
        dMaterial.setDescription(material.getDescription());
        dMaterial.setComments(material.getComments());

        return dMaterial;
    }
}
