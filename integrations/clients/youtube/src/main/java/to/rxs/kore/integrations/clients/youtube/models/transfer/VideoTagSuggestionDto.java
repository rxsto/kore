package to.rxs.kore.integrations.clients.youtube.models.transfer;

import lombok.Data;

import java.util.List;

@Data
public class VideoTagSuggestionDto {

    private String tag;
    private List<String> categoryRestricts;

}
