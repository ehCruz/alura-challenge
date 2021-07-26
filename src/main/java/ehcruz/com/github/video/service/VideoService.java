package ehcruz.com.github.video.service;

import ehcruz.com.github.video.model.Video;
import ehcruz.com.github.video.repository.VideoRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@ApplicationScoped
public class VideoService {

    @Inject
    private VideoRepository repository;

    public Video findVideo(Long id) {
        return repository.findById(id);
    }

    public List<Video> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Video createVideo(Video video) {
        return repository.save(video);
    }

    @Transactional
    public Video updateVideo(Video video) {
        return repository.update(video);
    }

    @Transactional
    public void deleteVideo(Long id) {
        repository.delete(id);
    }

}
