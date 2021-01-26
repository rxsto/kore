package to.rxs.kore.api.configs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration()
@ConfigurationProperties("youtube-api-client")
public class YouTubeClientConfig {

    private String youTubeApiKey;

}
