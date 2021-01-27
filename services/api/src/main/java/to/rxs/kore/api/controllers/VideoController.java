package to.rxs.kore.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import to.rxs.kore.api.services.youtube.LatestVideoService;
import to.rxs.kore.integrations.clients.youtube.models.Video;

@RequiredArgsConstructor
@RestController
@RequestMapping("/videos")
public class VideoController {

    private final LatestVideoService latestVideoService;

    @GetMapping("/latest")
    public Mono<Video> getLatestVideo() {
        return latestVideoService.requestLatestVideo();
    }

}
