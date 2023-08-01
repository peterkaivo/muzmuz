package io.github.peterkaivo.muzmuz.service;

import io.github.peterkaivo.muzmuz.common.exceptions.ItemNotFoundException;
import io.github.peterkaivo.muzmuz.service.model.File;

import java.util.List;

/**
 * Service class handling {@link io.github.peterkaivo.muzmuz.service.model.File}
 */
public interface FileService {
    public List<File> getAllFiles();
    public File getFile(Long id) throws ItemNotFoundException;
    public File saveFile(File acquisition);
}
