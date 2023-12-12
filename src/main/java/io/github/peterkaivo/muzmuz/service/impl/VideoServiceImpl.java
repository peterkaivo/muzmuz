package io.github.peterkaivo.muzmuz.service.impl;

import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundException;
import io.github.peterkaivo.muzmuz.common.exceptions.DBObjectNotFoundExceptionSupplier;
import io.github.peterkaivo.muzmuz.repository.VideoRepository;
import io.github.peterkaivo.muzmuz.repository.model.DVideo;
import io.github.peterkaivo.muzmuz.service.VideoService;
import io.github.peterkaivo.muzmuz.service.model.Video;
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
public class VideoServiceImpl implements VideoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(VideoService.class);

    @Autowired
    VideoRepository videoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Video> getAllVideos() {
        List<DVideo> videos = (List<DVideo>) videoRepository.findAll();

        return videos.stream().map(this::fromDVideo).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Video getVideo(Long id) throws DBObjectNotFoundException {
        DVideo dVideo = videoRepository.findById(id).orElseThrow(new DBObjectNotFoundExceptionSupplier(DVideo.class, id));

        return fromDVideo(dVideo);
    }

    @Override
    @Transactional(readOnly = true)
    public Set<Video> getVideoSet(Set<Long> ids) {
        Set<Video> videos = new HashSet<>();

        for (Long id : ids) {
            try {
                videos.add(getVideo(id));
            } catch (DBObjectNotFoundException e) {
                LOGGER.warn("getVideoSet() - DB inconsistency found for DVideo with ID = {}", id);
                LOGGER.info(e.getMessage());
            }
        }

        return videos;
    }

    @Override
    public Video saveVideo(Video video) {
        videoRepository.save(toDVideo(video));

        return video;
    }

    private Video fromDVideo(DVideo dVideo) {
        Video video = new Video();
        video.setId(dVideo.getId());
        video.setName(dVideo.getName());
        video.setFileName(dVideo.getFileName());
        video.setDescription(dVideo.getDescription());
        video.setComments(dVideo.getComments());
        video.setLength(dVideo.getLength());
        video.setResolution(dVideo.getResolution());
        video.setAcquired(dVideo.getAcquired());

        return video;
    }

    private DVideo toDVideo(Video video) {
        DVideo dVideo = new DVideo();
        dVideo.setId(video.getId());
        dVideo.setName(video.getName());
        dVideo.setFileName(video.getFileName());
        dVideo.setDescription(video.getDescription());
        dVideo.setComments(video.getComments());
        dVideo.setLength(video.getLength());
        dVideo.setResolution(video.getResolution());
        dVideo.setAcquired(video.getAcquired());

        return dVideo;
    }
}
