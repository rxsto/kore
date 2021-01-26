package to.rxs.kore.integrations.clients.youtube;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.flogger.Flogger;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import to.rxs.kore.integrations.clients.youtube.models.transfer.ResponseDto;
import to.rxs.kore.integrations.clients.youtube.strategies.models.http.YouTubeApiKeyFilterFunction;

@Flogger
public class YouTubeClient {

    private static final String API_VERSION = "v3";
    private static final String BASE_URL = String.format("https://www.googleapis.com/youtube/%s/search", API_VERSION);

    private static final int MAX_HTTP_BUFFER = 8 * 1024 * 1024;

    private final WebClient webClient;

    public YouTubeClient(String youTubeApiKey) {
        var objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
                .setSerializationInclusion(JsonInclude.Include.NON_NULL); // TODO: doesn't work

        this.webClient = WebClient.builder()
                .baseUrl(BASE_URL)
                .codecs(configurer -> {
                    var codecs = configurer.defaultCodecs();
                    codecs.maxInMemorySize(MAX_HTTP_BUFFER);
                    codecs.jackson2JsonEncoder(new Jackson2JsonEncoder(objectMapper));
                    codecs.jackson2JsonDecoder(new Jackson2JsonDecoder(objectMapper));
                })
                .filter(new YouTubeApiKeyFilterFunction(youTubeApiKey))
                .build();
    }

    public Mono<ResponseDto> getLatestVideo(String channelId) {
        return webClient.get()
                .uri(builder -> builder
                        .queryParam("part", "snippet")
                        .queryParam("channelId", "{channelId}")
                        .queryParam("maxResults", 5)
                        .queryParam("order", "date")
                        .queryParam("type", "video")
                        .build(channelId)
                )
                .retrieve()
                .bodyToMono(ResponseDto.class);
    }
}
