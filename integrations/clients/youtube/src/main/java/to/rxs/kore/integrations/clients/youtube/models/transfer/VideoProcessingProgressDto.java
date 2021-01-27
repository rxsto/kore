package to.rxs.kore.integrations.clients.youtube.models.transfer;

import lombok.Data;

@Data
public class VideoProcessingProgressDto {

    private Long partsTotal;
    private Long partsProcessed;
    private Long timeLeftMs;

}
