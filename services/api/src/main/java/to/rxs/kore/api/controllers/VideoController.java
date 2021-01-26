package to.rxs.kore.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import to.rxs.kore.integrations.clients.youtube.YouTubeClient;
import to.rxs.kore.integrations.clients.youtube.models.transfer.ResponseDto;

@RestController
@RequestMapping("/videos")
public class VideoController {

    private final YouTubeClient youTubeClient;

    public VideoController(YouTubeClient youTubeClient) {
        this.youTubeClient = youTubeClient;
    }

    @GetMapping("/latest")
    public Mono<ResponseDto> getLatestVideo(@RequestParam String channelId) {
        return youTubeClient.getLatestVideo(channelId);
    }

}
