package io.github.peterkaivo.muzmuz.service;

import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundException;
import io.github.peterkaivo.muzmuz.service.model.Video;

import java.util.List;
import java.util.Set;

/**
 * Service class handling {@link io.github.peterkaivo.muzmuz.service.model.Video}
 */
public interface VideoService {
    public List<Video> getAllVideos();
    public Video getVideo(Long id) throws DBObjectNotFoundException;
    public Set<Video> getVideoSet(Set<Long> ids);
    public Video saveVideo(Video video);
}
