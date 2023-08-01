package io.github.peterkaivo.muzmuz.service;

import io.github.peterkaivo.muzmuz.common.exceptions.ItemNotFoundException;
import io.github.peterkaivo.muzmuz.service.model.Video;

import java.util.List;

/**
 * Service class handling {@link io.github.peterkaivo.muzmuz.service.model.Video}
 */
public interface VideoService {
    public List<Video> getAllVideos();
    public Video getVideo(Long id) throws ItemNotFoundException;
    public Video saveVideo(Video acquisition);
}
