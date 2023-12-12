package io.github.peterkaivo.muzmuz.service.impl;

import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundException;
import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundExceptionSupplier;
import io.github.peterkaivo.muzmuz.repository.AudioRepository;
import io.github.peterkaivo.muzmuz.repository.model.DAudio;
import io.github.peterkaivo.muzmuz.service.AudioService;
import io.github.peterkaivo.muzmuz.service.model.Audio;
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
public class AudioServiceImpl implements AudioService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AudioService.class);

    @Autowired
    private AudioRepository audioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Audio> getAllAudio() {
        List<DAudio> audioList = (List<DAudio>) audioRepository.findAll();
        return audioList.stream().map(this::fromDAudio).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Audio getAudio(Long id) throws DBObjectNotFoundException {
        DAudio audio =audioRepository.findById(id).orElseThrow(new DBObjectNotFoundExceptionSupplier(DAudio.class, id));
        return fromDAudio(audio);
    }

    @Override
    @Transactional(readOnly = true)
    public Set<Audio> getAudioSet(Set<Long> ids) {
        Set<Audio> audioSet = new HashSet<>();

        for (Long id : ids) {
            try {
                audioSet.add(getAudio(id));
            } catch (DBObjectNotFoundException e) {
                LOGGER.warn("getAudioSet() - DB inconsistency found for DAudio with ID = {}", id);
                LOGGER.info(e.getMessage());
            }
        }

        return audioSet.isEmpty() ? null : audioSet;
    }

    @Override
    public Audio saveAudio(Audio audio) {
        audioRepository.save(toDAudio(audio));
        return audio;
    }

    private Audio fromDAudio(DAudio dAudio) {
        Audio audio = new Audio();
        audio.setId(dAudio.getId());
        audio.setName(dAudio.getName());
        audio.setFileName(dAudio.getFileName());
        audio.setDescription(dAudio.getDescription());
        audio.setComments(dAudio.getComments());
        audio.setLength(dAudio.getLength());

        return audio;
    }

    private DAudio toDAudio(Audio audio) {
        DAudio dAudio = new DAudio();
        dAudio.setId(audio.getId());
        dAudio.setName(audio.getName());
        dAudio.setFileName(audio.getFileName());
        dAudio.setDescription(audio.getDescription());
        dAudio.setComments(audio.getComments());
        dAudio.setLength(audio.getLength());

        return dAudio;
    }
}
