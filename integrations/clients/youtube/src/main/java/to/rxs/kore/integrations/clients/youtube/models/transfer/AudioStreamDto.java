package to.rxs.kore.integrations.clients.youtube.models.transfer;

import lombok.Data;

@Data
public class AudioStreamDto {

    private Integer channelCount;
    private String codec;
    private Long bitrateBps;
    private String vendor;

}
