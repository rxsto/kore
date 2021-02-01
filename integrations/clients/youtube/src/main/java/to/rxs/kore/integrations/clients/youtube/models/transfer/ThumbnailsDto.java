package to.rxs.kore.integrations.clients.youtube.models.transfer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ThumbnailsDto {

    @JsonProperty("default")
    private ThumbnailDto defaultThumbnail;
    private ThumbnailDto medium;
    private ThumbnailDto high;
    private ThumbnailDto standard;
    private ThumbnailDto maxres;

}
