package to.rxs.kore.integrations.clients.youtube;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.flogger.Flogger;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import to.rxs.kore.integrations.clients.youtube.deser.YouTubeResourceModule;
import to.rxs.kore.integrations.clients.youtube.models.Video;
import to.rxs.kore.integrations.clients.youtube.models.transfer.ResponseDto;
import to.rxs.kore.integrations.clients.youtube.models.transfer.SearchResultDto;
import to.rxs.kore.integrations.clients.youtube.models.transfer.VideoDto;
import to.rxs.kore.integrations.clients.youtube.strategies.models.http.YouTubeApiKeyFilterFunction;

@Flogger
public class YouTubeClient {

    private static final String API_VERSION = "v3";

    private static final String BASE_URL = "https://www.googleapis.com/youtube";
    private static final String BASE_URL_WITH_VERSION = String.format("%s/%s", BASE_URL, API_VERSION);

    private static final String VIDEO_PATH = "/videos";
    private static final String SEARCH_PATH = "/search";

    private static final String DEFAULT_VIDEO_PART_QUERY = "snippet,contentDetails,status,statistics,player,topicDetails,recordingDetails,liveStreamingDetails,localizations";

    private static final int MAX_HTTP_BUFFER = 8 * 1024 * 1024;

    private final String youTubeChannelId;

    private final WebClient webClient;

    public YouTubeClient(String youTubeApiKey, String youTubeChannelId) {
        this.youTubeChannelId = youTubeChannelId;

        var objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
                .registerModule(new YouTubeResourceModule());

        this.webClient = WebClient.builder()
                .baseUrl(BASE_URL_WITH_VERSION)
                .codecs(configurer -> {
                    var codecs = configurer.defaultCodecs();
                    codecs.maxInMemorySize(MAX_HTTP_BUFFER);
                    codecs.jackson2JsonEncoder(new Jackson2JsonEncoder(objectMapper));
                    codecs.jackson2JsonDecoder(new Jackson2JsonDecoder(objectMapper));
                })
                .filter(new YouTubeApiKeyFilterFunction(youTubeApiKey))
                .build();
    }

    public Mono<Video> getLatestVideo() {
        return webClient.get()
                .uri(builder -> builder
                        .path(SEARCH_PATH)
                        .queryParam("part", "snippet")
                        .queryParam("type", "video")
                        .queryParam("order", "date")
                        .queryParam("maxResults", 1)
                        .queryParam("channelId", "{channelId}")
                        .build(youTubeChannelId)
                )
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<ResponseDto<SearchResultDto>>() {
                })
                .flatMapIterable(ResponseDto::getItems)
                .next()
                .flatMap(this::getVideoFromSearchResult)
                .map(this::buildVideoFromResponse);
    }

    public Mono<VideoDto> getVideoFromSearchResult(SearchResultDto result) {
        return getVideo(result.getId().getVideoId());
    }

    public Mono<VideoDto> getVideo(String id) {
        return webClient.get()
                .uri(builder -> builder
                        .path(VIDEO_PATH)
                        .queryParam("part", DEFAULT_VIDEO_PART_QUERY)
                        .queryParam("id", "{id}")
                        .build(id)
                )
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<ResponseDto<VideoDto>>() {
                })
                .flatMapIterable(ResponseDto::getItems)
                .next();
    }

    public Video buildVideoFromResponse(VideoDto videoDto) {
        return Video.builder()
                .id(videoDto.getId())
                .publishedAt(videoDto.getSnippet().getPublishedAt())
                .title(videoDto.getSnippet().getTitle())
                .description(videoDto.getSnippet().getDescription())
                .channelId(videoDto.getSnippet().getChannelId())
                .channelTitle(videoDto.getSnippet().getChannelTitle())
                .tags(videoDto.getSnippet().getTags())
                .thumbnails(videoDto.getSnippet().getThumbnails())
                .categoryId(videoDto.getSnippet().getCategoryId())
                .liveBroadcastContent(videoDto.getSnippet().getLiveBroadcastContent())
                .defaultLanguage(videoDto.getSnippet().getDefaultLanguage())
                .defaultAudioLanguage(videoDto.getSnippet().getDefaultAudioLanguage())
                .duration(videoDto.getContentDetails().getDuration())
                .viewCount(videoDto.getStatistics().getViewCount())
                .likeCount(videoDto.getStatistics().getLikeCount())
                .dislikeCount(videoDto.getStatistics().getDislikeCount())
                .commentCount(videoDto.getStatistics().getCommentCount())
                .build();
    }
}
