package ehcruz.com.github.video.repository;

import ehcruz.com.github.video.model.Video;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class VideoRepository extends AbstractRepository<Video, Long> {

    protected VideoRepository() {
        super(Video.class);
    }

}
