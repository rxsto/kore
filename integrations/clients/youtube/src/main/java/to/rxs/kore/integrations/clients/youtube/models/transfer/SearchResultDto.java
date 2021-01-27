package to.rxs.kore.integrations.clients.youtube.models.transfer;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SearchResultDto extends ResourceDto {

    private SearchResultIdDto id;
    private SearchResultSnippetDto snippet;

}
