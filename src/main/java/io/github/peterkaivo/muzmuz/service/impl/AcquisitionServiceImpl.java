package io.github.peterkaivo.muzmuz.service.impl;

import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundException;
import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundExceptionSupplier;
import io.github.peterkaivo.muzmuz.repository.AcquisitionRepository;
import io.github.peterkaivo.muzmuz.repository.model.DAcquisition;
import io.github.peterkaivo.muzmuz.service.*;
import io.github.peterkaivo.muzmuz.service.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class AcquisitionServiceImpl implements AcquisitionService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AcquisitionService.class);

    @Autowired
    private AcquisitionRepository acquisitionRepository;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private ImageGalleryService imageGalleryService;
    @Autowired
    private AudioService audioService;
    @Autowired
    private VideoService videoService;
    @Autowired
    private FileService fileService;
    @Autowired
    private LinkService linkService;

    @Override
    @Transactional(readOnly = true)
    public List<Acquisition> getAllAcquisitions() {
        List<DAcquisition> dAcquisitions = (List<DAcquisition>) acquisitionRepository.findAll();

        return dAcquisitions.stream().map(this::fromDAcquisition).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Acquisition getAcquisition(Long id) throws DBObjectNotFoundException {
        DAcquisition dAcquisition = acquisitionRepository.findById(id).orElseThrow(new DBObjectNotFoundExceptionSupplier(DAcquisition.class, id));
        return fromDAcquisition(dAcquisition);
    }

    @Override
    public Acquisition saveAcquisition(Acquisition acquisition) {
        acquisitionRepository.save(toDAcquisition(acquisition));
        return acquisition;
    }

    @Override
    @Transactional(readOnly = true)
    public Acquisition getAcquisitionTruncated(Long id) throws DBObjectNotFoundException {
        DAcquisition dAcquisition = acquisitionRepository.findById(id).orElseThrow(new DBObjectNotFoundExceptionSupplier(DAcquisition.class, id));
        return fromDAcquisitionTruncated(dAcquisition);
    }

    @Override
    @Transactional(readOnly = true)
    public Set<Acquisition> getAcquisitionsTruncated(Set<Long> ids) {
        Set<Acquisition> acquisitions = new HashSet<>();

        for (Long id : ids) {
            try {
                acquisitions.add(getAcquisitionTruncated(id));
            } catch (DBObjectNotFoundException e) {
                LOGGER.warn("getAcquisitionsTruncated() - DB inconsistency found for DAcquisition with ID = {}", id);
                LOGGER.info(e.getMessage());
            }
        }

        return acquisitions.isEmpty() ? Collections.emptySet() : acquisitions;
    }

    private Acquisition fromDAcquisition(DAcquisition dAcquisition) {
        Acquisition acquisition = new Acquisition();
        acquisition.setId(dAcquisition.getId());
        acquisition.setAcquisitionType(dAcquisition.getAcquisitionType());
        acquisition.setAcquisitionDate(dAcquisition.getAcquisitionDate());

        try {
            acquisition.setAcquiredFrom(dAcquisition.getAcquiredFrom() == null ? null : subjectService.getSubjectTruncated(dAcquisition.getAcquiredFrom()));
        } catch (DBObjectNotFoundException e) {
            LOGGER.warn("fromDAcquisition() - DB inconsistency found for DAcquisition with ID = {}", dAcquisition.getId());
            LOGGER.info(e.getMessage());
            acquisition.setAcquiredFrom(null);
        }

        acquisition.setAcquiredItems(dAcquisition.getAcquiredItems() == null ? null : itemService.getItemsTruncated(dAcquisition.getAcquiredItems()));

        handleGetGalleries(acquisition, dAcquisition);

        acquisition.setAudio(dAcquisition.getAudio() == null ? Collections.emptySet() : audioService.getAudioSet(dAcquisition.getAudio()));
        acquisition.setVideo(dAcquisition.getVideo() == null ? Collections.emptySet() : videoService.getVideoSet(dAcquisition.getVideo()));
        acquisition.setFiles(dAcquisition.getFiles() == null ? Collections.emptySet() : fileService.getFileSet(dAcquisition.getFiles()));
        acquisition.setLinks(dAcquisition.getLinks() == null ? Collections.emptySet() : linkService.getLinkSet(dAcquisition.getLinks()));
        acquisition.setDescription(dAcquisition.getDescription());
        acquisition.setComments(dAcquisition.getComments());

        return acquisition;
    }

    private void handleGetGalleries(Acquisition acquisition, DAcquisition dAcquisition) {
        if (dAcquisition.getGalleries() != null) {
            Set<ImageGallery> galleries = imageGalleryService.getImageGalleries(dAcquisition.getGalleries());

            acquisition.setGalleries(galleries);
            acquisition.setDefaultGallery(galleries == null || dAcquisition.getDefaultGallery() == null ? null : findGallery(galleries, dAcquisition));
        } else {
            if (dAcquisition.getDefaultGallery() != null) {
                LOGGER.warn("handleGetGalleries() - DB inconsistency found for DAcquisition with ID = {}: default ImageGallery with ID = {} assigned but not present in Galleries collection",
                        dAcquisition.getId(), dAcquisition.getDefaultGallery());
            }

            acquisition.setGalleries(Collections.emptySet());
            acquisition.setDefaultGallery(null);
        }
    }

    private ImageGallery findGallery(Set<ImageGallery> galleries, DAcquisition dAcquisition) {
        for (ImageGallery gallery : galleries) {
            if (gallery.getId().equals(dAcquisition.getDefaultGallery())) {
                return gallery;
            }
        }

        LOGGER.warn("findGallery() - DB inconsistency found for DAcquisition with ID = {}: default ImageGallery with ID = {} not found", dAcquisition.getId(), dAcquisition.getDefaultGallery());
        return null;
    }

    private Acquisition fromDAcquisitionTruncated(DAcquisition dAcquisition) throws DBObjectNotFoundException {
        Acquisition acquisition = new Acquisition();
        acquisition.setId(dAcquisition.getId());
        acquisition.setAcquisitionType(dAcquisition.getAcquisitionType());
        acquisition.setAcquisitionDate(dAcquisition.getAcquisitionDate());
        acquisition.setAcquiredFrom(dAcquisition.getAcquiredFrom() == null ? null : subjectService.getSubjectTruncated(dAcquisition.getAcquiredFrom()));

        return acquisition;
    }

    private DAcquisition toDAcquisition(Acquisition acquisition) {
        DAcquisition dAcquisition = new DAcquisition();
        dAcquisition.setId(acquisition.getId());
        dAcquisition.setAcquisitionType(acquisition.getAcquisitionType());
        dAcquisition.setAcquisitionDate(acquisition.getAcquisitionDate());
        dAcquisition.setAcquiredFrom(acquisition.getAcquiredFrom() == null ? null : acquisition.getAcquiredFrom().getId());
        dAcquisition.setAcquiredItems(acquisition.getAcquiredItems() == null ? null : acquisition.getAcquiredItems().stream().map(Item::getId).collect(Collectors.toSet()));
        dAcquisition.setDefaultGallery(acquisition.getDefaultGallery() == null ? null : acquisition.getDefaultGallery().getId());
        dAcquisition.setGalleries(acquisition.getGalleries() == null ? null : acquisition.getGalleries().stream().map(ImageGallery::getId).collect(Collectors.toSet()));
        dAcquisition.setAudio(acquisition.getAudio() == null ? null : acquisition.getAudio().stream().map(Audio::getId).collect(Collectors.toSet()));
        dAcquisition.setVideo(acquisition.getVideo() == null ? null : acquisition.getVideo().stream().map(Video::getId).collect(Collectors.toSet()));
        dAcquisition.setFiles(acquisition.getFiles() == null ? null : acquisition.getFiles().stream().map(File::getId).collect(Collectors.toSet()));
        dAcquisition.setLinks(acquisition.getLinks() == null ? null : acquisition.getLinks().stream().map(Link::getId).collect(Collectors.toSet()));
        dAcquisition.setDescription(acquisition.getDescription());
        dAcquisition.setComments(acquisition.getComments());
        return dAcquisition;
    }
}
