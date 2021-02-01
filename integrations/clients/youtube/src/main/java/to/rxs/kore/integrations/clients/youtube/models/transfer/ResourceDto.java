package to.rxs.kore.integrations.clients.youtube.models.transfer;

import lombok.Data;

@Data
public abstract class ResourceDto {

    private String kind;
    private String etag;

}
