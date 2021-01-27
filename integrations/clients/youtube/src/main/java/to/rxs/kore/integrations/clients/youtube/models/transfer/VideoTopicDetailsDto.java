package to.rxs.kore.integrations.clients.youtube.models.transfer;

import lombok.Data;

import java.util.List;

@Data
public class VideoTopicDetailsDto {

    private List<String> topicIds;
    private List<String> relevantTopicIds;
    private List<String> topicCategories;

}
