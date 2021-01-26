package to.rxs.kore.integrations.clients.youtube.models.transfer;

import lombok.Data;

@Data
public class ResultDto {

    private String kind;
    private String etag;
    private ResultIdDto id;
    private ResultSnippetDto snippet;
}
