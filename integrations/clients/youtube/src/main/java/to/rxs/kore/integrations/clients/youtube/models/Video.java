package to.rxs.kore.integrations.clients.youtube.models;

import lombok.Builder;
import lombok.Data;
import to.rxs.kore.integrations.clients.youtube.models.transfer.ThumbnailsDto;

import java.util.List;

@Data
@Builder
public class Video {

    private String id;
    private String publishedAt;
    private String title;
    private String description;
    private String channelId;
    private String channelTitle;
    private List<String> tags;
    private ThumbnailsDto thumbnails;
    private String categoryId;
    private String liveBroadcastContent;
    private String defaultLanguage;
    private String defaultAudioLanguage;
    private String duration;
    private Long viewCount;
    private Long likeCount;
    private Long dislikeCount;
    private Long commentCount;

}
