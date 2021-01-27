package to.rxs.kore.integrations.clients.youtube.models.transfer;

import lombok.Data;

@Data
public class VideoStatisticsDto {

    private Long viewCount;
    private Long likeCount;
    private Long dislikeCount;
    private Long favoriteCount;
    private Long commentCount;

}
