package io.github.peterkaivo.muzmuz.service;

import io.github.peterkaivo.muzmuz.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class SubjectServiceTest {
    @Autowired
    private SubjectService subjectService;
    @MockBean
    SubjectRepository subjectRepository;
    @MockBean
    AddressService addressService;
    @MockBean
    ImageGalleryService imageGalleryService;
    @MockBean
    AudioService audioService;
    @MockBean
    VideoService videoService;
    @MockBean
    FileService fileService;
    @MockBean
    LinkService linkService;
}
