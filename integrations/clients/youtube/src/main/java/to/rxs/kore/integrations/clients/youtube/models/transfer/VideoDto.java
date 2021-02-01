package to.rxs.kore.integrations.clients.youtube.models.transfer;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class VideoDto extends ResourceDto {

    private String id;
    private VideoSnippetDto snippet;
    private VideoContentDetailsDto contentDetails;
    private VideoStatusDto status;
    private VideoStatisticsDto statistics;
    private VideoPlayerDto player;
    private VideoTopicDetailsDto topicDetails;
    private VideoRecordingDetailsDto recordingDetails;
    private VideoFileDetailsDto fileDetails;
    private VideoProcessingDetailsDto processingDetails;
    private VideoSuggestionsDto suggestions;
    private VideoLiveStreamingDetailsDto liveStreamingDetails;
    private Map<String, LocalizedDto> localizations;

}
