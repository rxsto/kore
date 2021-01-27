package to.rxs.kore.integrations.clients.youtube.models.transfer;

import lombok.Data;

@Data
public class VideoStreamDto {

    private Integer widthPixels;
    private Integer heightPixels;
    private Double frameRateFps;
    private Double aspectRatio;
    private String codec;
    private Long bitrateBps;
    private String rotation;
    private String vendor;

}
