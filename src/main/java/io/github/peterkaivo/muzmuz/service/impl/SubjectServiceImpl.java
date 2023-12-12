package io.github.peterkaivo.muzmuz.service.impl;

import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundException;
import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundExceptionSupplier;
import io.github.peterkaivo.muzmuz.common.types.MediaType;
import io.github.peterkaivo.muzmuz.repository.SubjectRepository;
import io.github.peterkaivo.muzmuz.repository.model.DCompany;
import io.github.peterkaivo.muzmuz.repository.model.DPerson;
import io.github.peterkaivo.muzmuz.repository.model.DSubject;
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
public class SubjectServiceImpl implements SubjectService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SubjectService.class);

    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private AddressService addressService;
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
    public List<Subject> getAllSubjects() {
        List<DSubject> dSubjects = (List<DSubject>) subjectRepository.findAll();
        List<Subject> subjects = new ArrayList<>();

        for (DSubject dSubject : dSubjects) {
            switch (dSubject.getSubjectType()) {
                case PERSON -> subjects.add(fromDPerson((DPerson) dSubject));
                case COMPANY -> subjects.add(fromDCompany((DCompany) dSubject));
                default -> LOGGER.trace("getAllSubjects() - Unsupported SubjectType of DSubject with ID = {}", dSubject.getId());
            }
        }

        return subjects;
    }

    @Override
    @Transactional(readOnly = true)
    public Subject getSubject(Long id) throws DBObjectNotFoundException {

        DSubject dSubject = subjectRepository.findById(id).orElseThrow(new DBObjectNotFoundExceptionSupplier(DSubject.class, id));

        return switch (dSubject.getSubjectType()) {
            case PERSON -> fromDPerson((DPerson) dSubject);
            case COMPANY -> fromDCompany((DCompany) dSubject);
            default -> null;
        };
    }

    @Override
    public Subject saveSubject(Subject subject) {
        switch (subject.getSubjectType()) {
            case PERSON -> subjectRepository.save(toDPerson((Person) subject));
            case COMPANY -> subjectRepository.save(toDCompany((Company) subject));
            default -> LOGGER.warn("saveSubject() - Unsupported SubjectType of Subject with ID = {}", subject.getId());
        }

        return subject;
    }

    @Override
    @Transactional(readOnly = true)
    public Subject getSubjectTruncated(Long id) throws DBObjectNotFoundException {
        DSubject dSubject = subjectRepository.findById(id).orElseThrow(new DBObjectNotFoundExceptionSupplier(DSubject.class, id));

        return switch (dSubject.getSubjectType()) {
            case PERSON -> fromDPersonTruncated((DPerson) dSubject);
            case COMPANY -> fromDCompanyTruncated((DCompany) dSubject);
            default -> null;
        };
    }

    @Override
    @Transactional(readOnly = true)
    public Set<Subject> getSubjectsTruncated(Set<Long> ids) {
        Set<Subject> subjects = new HashSet<>();

        for (Long id : ids) {
            try {
                subjects.add(getSubjectTruncated(id));
            } catch (DBObjectNotFoundException e) {
                LOGGER.warn("getSubjectsTruncated() - DB inconsistency found for DSubject with ID = {}", id);
                LOGGER.info(e.getMessage());
            }
        }

        return subjects.isEmpty() ? null : subjects;
    }

    private Subject fromDPerson(DPerson dPerson) {
        Person person = new Person();

        fillSubject(person, dPerson);

        person.setFirstName(dPerson.getFirstName());
        person.setMiddleName(dPerson.getMiddleName());
        person.setLastName(dPerson.getLastName());
        person.setBirth(dPerson.getBirth());

        return person;
    }

    private Subject fromDCompany(DCompany dCompany) {
        Company company = new Company();

        fillSubject(company, dCompany);

        company.setName(dCompany.getName());
        company.setFounded(dCompany.getFounded());

        return company;
    }

    private void fillSubject(Subject subject, DSubject dSubject) {
        subject.setId(dSubject.getId());

        try {
            subject.setAddress(dSubject.getAddress() == null ? null : addressService.getAddress(dSubject.getAddress()));
        } catch (DBObjectNotFoundException e) {
            LOGGER.warn("fillDSubject() - DB inconsistency found for {} with ID = {}", dSubject.getClass().getSimpleName(), dSubject.getId());
            LOGGER.info(e.getMessage());
        }

        handleGetGalleries(subject, dSubject);

        subject.setAudio(dSubject.getAudio() == null ? Collections.emptySet() : audioService.getAudioSet(dSubject.getAudio()));
        subject.setVideo(dSubject.getVideo() == null ? Collections.emptySet() : videoService.getVideoSet(dSubject.getVideo()));
        subject.setFiles(dSubject.getFiles() == null ? Collections.emptySet() : fileService.getFileSet(dSubject.getFiles()));
        subject.setLinks(dSubject.getLinks() == null ? Collections.emptySet() : linkService.getLinkSet(dSubject.getLinks()));
        subject.setDescription(dSubject.getDescription());
        subject.setComments(dSubject.getComments());
    }

    private void handleGetGalleries(Subject subject, DSubject dSubject) {
        if (dSubject.getGalleries() != null) {
            Set<ImageGallery> galleries = imageGalleryService.getImageGalleries(dSubject.getGalleries());

            subject.setGalleries(galleries);
            subject.setDefaultGallery(galleries == null || dSubject.getDefaultGallery() == null ? null : findGallery(galleries, dSubject));
            subject.setDefaultPhoto(subject.getDefaultGallery() == null || dSubject.getDefaultPhoto() == null ? null : findDefaultPhoto(subject.getDefaultGallery(), dSubject));
        } else {
            if (dSubject.getDefaultGallery() != null) {
                LOGGER.warn("handleGetGalleries() - DB inconsistency found for DAcquisition with ID = {}: default ImageGallery with ID = {} assigned but not present in Galleries collection",
                        dSubject.getId(), dSubject.getDefaultGallery());
            }

            subject.setGalleries(Collections.emptySet());
            subject.setDefaultGallery(null);
            subject.setDefaultPhoto(null);
        }
    }

    private ImageGallery findGallery(Set<ImageGallery> galleries, DSubject dSubject) {
        for (ImageGallery gallery : galleries) {
            if (gallery.getId().equals(dSubject.getDefaultGallery())) {
                return gallery;
            }
        }

        LOGGER.warn("findGallery() - DB inconsistency found for {} with ID = {}: default ImageGallery with ID = {} not found", dSubject.getClass().getSimpleName(), dSubject.getId(), dSubject.getDefaultGallery());
        return null;
    }

    private Photo findDefaultPhoto(ImageGallery gallery, DSubject dSubject) {
        for (Graphics graphics : gallery.getImages()) {
            if (graphics.getId().equals(dSubject.getDefaultPhoto())) {
                if (MediaType.PHOTO.equals(graphics.getType())) {
                    return (Photo) graphics;
                } else {
                    LOGGER.warn("findDefaultPhoto() - DB inconsistency found for {} with ID = {}: default Photo with ID = {} is not Photo but {}", dSubject.getClass().getSimpleName(), dSubject.getId(), dSubject.getDefaultPhoto(), graphics.getType().toString());
                    return null;
                }
            }
        }

        LOGGER.warn("findDefaultPhoto() - DB inconsistency found for {} with ID = {}: default Photo with ID = {} not found in default Gallery {}", dSubject.getClass().getSimpleName(), dSubject.getId(), dSubject.getDefaultPhoto(), gallery.getId());
        return null;
    }

    private Subject fromDPersonTruncated(DPerson dPerson) {
        Person person = new Person();
        person.setId(dPerson.getId());
        person.setFirstName(dPerson.getFirstName());
        person.setMiddleName(dPerson.getMiddleName());
        person.setLastName(dPerson.getLastName());
        person.setBirth(dPerson.getBirth());

        return person;
    }

    private Company fromDCompanyTruncated(DCompany dCompany) {
        Company company = new Company();
        company.setId(dCompany.getId());
        company.setName(dCompany.getName());
        company.setFounded(dCompany.getFounded());

        return company;
    }

    private DPerson toDPerson(Person person) {
        DPerson dPerson = new DPerson();

        fillDSubject(dPerson, person);

        dPerson.setFirstName(person.getFirstName());
        dPerson.setMiddleName(person.getMiddleName());
        dPerson.setLastName(person.getLastName());
        dPerson.setBirth(person.getBirth());

        return dPerson;
    }

    private DCompany toDCompany(Company company) {
        DCompany dCompany = new DCompany();

        fillDSubject(dCompany, company);

        dCompany.setName(company.getName());
        dCompany.setFounded(company.getFounded());

        return dCompany;
    }

    private void fillDSubject(DSubject dSubject, Subject subject) {
        dSubject.setId(subject.getId());
        dSubject.setAddress(subject.getAddress() == null ? null : subject.getAddress().getId());
        dSubject.setDefaultPhoto(subject.getDefaultPhoto() == null ? null : subject.getDefaultPhoto().getId());
        dSubject.setDefaultGallery(subject.getDefaultGallery() == null ? null : subject.getDefaultGallery().getId());
        dSubject.setGalleries(subject.getGalleries() == null ? null : subject.getGalleries().stream().map(ImageGallery::getId).collect(Collectors.toSet()));
        dSubject.setAudio(subject.getAudio() == null ? null : subject.getAudio().stream().map(Audio::getId).collect(Collectors.toSet()));
        dSubject.setVideo(subject.getVideo() == null ? null : subject.getVideo().stream().map(Video::getId).collect(Collectors.toSet()));
        dSubject.setFiles(subject.getFiles() == null ? null : subject.getFiles().stream().map(File::getId).collect(Collectors.toSet()));
        dSubject.setLinks(subject.getLinks() == null ? null : subject.getLinks().stream().map(Link::getId).collect(Collectors.toSet()));
        dSubject.setDescription(subject.getDescription());
        dSubject.setComments(subject.getComments());
    }
}
