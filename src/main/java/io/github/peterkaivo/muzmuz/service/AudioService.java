package io.github.peterkaivo.muzmuz.service;

import io.github.peterkaivo.muzmuz.common.exceptions.ItemNotFoundException;
import io.github.peterkaivo.muzmuz.service.model.Audio;

import java.util.List;

/**
 * Service class handling {@link io.github.peterkaivo.muzmuz.service.model.Audio}
 */
public interface AudioService {
    public List<Audio> getAllAudio();
    public Audio getAudio(Long id) throws ItemNotFoundException;
    public Audio saveAudio(Audio acquisition);
}
