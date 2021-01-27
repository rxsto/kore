package to.rxs.kore.integrations.clients.youtube.models.transfer;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ResponseDto<T extends ResourceDto> extends ResourceDto {

    private String nextPageToken;
    private String prevPageToken;
    private String regionCode;
    private PageInfoDto pageInfo;
    private List<T> items;

}
