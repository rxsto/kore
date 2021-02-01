package to.rxs.kore.integrations.clients.youtube.models.transfer;

import lombok.Data;

import java.util.List;

@Data
public class VideoSnippetDto {

    private String publishedAt;
    private String channelId;
    private String title;
    private String description;
    private ThumbnailsDto thumbnails;
    private String channelTitle;
    private List<String> tags;
    private String categoryId;
    private String liveBroadcastContent;
    private String defaultLanguage;
    private LocalizedDto localized;
    private String defaultAudioLanguage;

}
