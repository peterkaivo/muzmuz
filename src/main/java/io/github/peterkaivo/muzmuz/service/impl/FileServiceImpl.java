package io.github.peterkaivo.muzmuz.service.impl;

import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundException;
import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundExceptionSupplier;
import io.github.peterkaivo.muzmuz.repository.FileRepository;
import io.github.peterkaivo.muzmuz.repository.model.DFile;
import io.github.peterkaivo.muzmuz.service.FileService;
import io.github.peterkaivo.muzmuz.service.model.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class FileServiceImpl implements FileService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileService.class);

    @Autowired
    FileRepository fileRepository;

    @Override
    @Transactional(readOnly = true)
    public List<File> getAllFiles() {
        List<DFile> dFiles = (List<DFile>) fileRepository.findAll();

        return dFiles.stream().map(this::fromDFile).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public File getFile(Long id) throws DBObjectNotFoundException {
        DFile dFile = fileRepository.findById(id).orElseThrow(new DBObjectNotFoundExceptionSupplier(DFile.class, id));

        return fromDFile(dFile);
    }

    @Override
    @Transactional(readOnly = true)
    public Set<File> getFileSet(Set<Long> ids) {
        Set<File> files = new HashSet<>();

        for (Long id : ids) {
            try {
                files.add(getFile(id));
            } catch (DBObjectNotFoundException e) {
                LOGGER.warn("getFileSet() - DB inconsistency found for DFile with ID = {}", id);
                LOGGER.info(e.getMessage());
            }
        }
        return files.isEmpty() ? Collections.emptySet() : files;
    }

    @Override
    public File saveFile(File file) {
        fileRepository.save(toDFile(file));

        return file;
    }

    private File fromDFile(DFile dFile) {
        File file = new File();
        file.setId(dFile.getId());
        file.setName(dFile.getName());
        file.setFileName(dFile.getFileName());
        file.setDescription(dFile.getDescription());
        file.setComments(dFile.getComments());

        return file;
    }

    private DFile toDFile(File file) {
        DFile dFile = new DFile();
        dFile.setId(file.getId());
        dFile.setName(file.getName());
        dFile.setFileName(file.getFileName());
        dFile.setDescription(file.getDescription());
        dFile.setComments(file.getComments());

        return dFile;
    }
}
