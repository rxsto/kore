package to.rxs.kore.api.factories;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import to.rxs.kore.api.configs.YouTubeClientConfig;
import to.rxs.kore.integrations.clients.youtube.YouTubeClient;

@Component
public class YouTubeClientFactory {

    @Bean
    public YouTubeClient getYouTubeClient(YouTubeClientConfig youTubeClientConfig) {
        return new YouTubeClient(youTubeClientConfig.getYouTubeApiKey());
    }
}
