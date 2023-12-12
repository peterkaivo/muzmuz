package io.github.peterkaivo.muzmuz.service;

import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundException;
import io.github.peterkaivo.muzmuz.service.model.Audio;

import java.util.List;
import java.util.Set;

/**
 * Service class handling {@link io.github.peterkaivo.muzmuz.service.model.Audio}
 */
public interface AudioService {
    public List<Audio> getAllAudio();
    public Audio getAudio(Long id) throws DBObjectNotFoundException;
    public Set<Audio> getAudioSet(Set<Long> ids);
    public Audio saveAudio(Audio audio);
}
