package to.rxs.kore.integrations.clients.youtube.models.transfer;

import lombok.Data;

@Data
public class ResultSnippetDto {

    private String publishedAt;
    private String channelId;
    private String title;
    private String description;
    private ThumbnailsDto thumbnails;
    private String channelTitle;
    private String liveBroadcastContent;
    private String publishTime;
}
