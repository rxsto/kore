package to.rxs.kore.integrations.clients.youtube.models.transfer;

import lombok.Data;

import java.util.List;

@Data
public class VideoRegionRestrictionDto {

    private List<String> allowed;
    private List<String> blocked;

}
