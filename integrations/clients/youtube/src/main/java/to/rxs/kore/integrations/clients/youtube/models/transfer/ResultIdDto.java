package to.rxs.kore.integrations.clients.youtube.models.transfer;

import lombok.Data;

@Data
public class ResultIdDto {

    private String kind;
    private String videoId;
    private String channelId;
    private String playlistId;

}
