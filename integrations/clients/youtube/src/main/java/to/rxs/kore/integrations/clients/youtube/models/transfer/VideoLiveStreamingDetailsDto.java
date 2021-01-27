package to.rxs.kore.integrations.clients.youtube.models.transfer;

import lombok.Data;

@Data
public class VideoLiveStreamingDetailsDto {

    private String actualStartTime;
    private String actualEndTime;
    private String scheduledStartTime;
    private String scheduledEndTime;
    private Long concurrentViewers;
    private String activeLiveChatId;

}
