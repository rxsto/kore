package to.rxs.kore.integrations.clients.youtube.models.transfer;

import lombok.Data;

import java.util.List;

@Data
public class ResponseDto {

    private String kind;
    private String etag;
    private String nextPageToken;
    private String prevPageToken;
    private String regionCode;
    private PageInfoDto pageInfo;
    private List<ResultDto> items;

}
