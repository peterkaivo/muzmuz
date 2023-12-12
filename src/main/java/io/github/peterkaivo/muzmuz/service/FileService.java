package io.github.peterkaivo.muzmuz.service;

import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundException;
import io.github.peterkaivo.muzmuz.service.model.File;

import java.util.List;
import java.util.Set;

/**
 * Service class handling {@link io.github.peterkaivo.muzmuz.service.model.File}
 */
public interface FileService {
    public List<File> getAllFiles();
    public File getFile(Long id) throws DBObjectNotFoundException;
    public Set<File> getFileSet(Set<Long> ids);
    public File saveFile(File file);
}
