package to.rxs.kore.api.services.youtube;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import to.rxs.kore.integrations.clients.youtube.YouTubeClient;
import to.rxs.kore.integrations.clients.youtube.models.Video;

import java.time.Duration;

@Service
public class LatestVideoService {

    private final static Duration LATEST_VIDEO_CACHE_DURATION = Duration.ofHours(2);

    private final Mono<Video> cachedVideo;

    public LatestVideoService(YouTubeClient youTubeClient) {
        this.cachedVideo = youTubeClient.getLatestVideo()
                .cache(LATEST_VIDEO_CACHE_DURATION);
    }

    public Mono<Video> requestLatestVideo() {
        return cachedVideo;
    }
}
