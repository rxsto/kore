package to.rxs.kore.integrations.clients.youtube.models.transfer;

import lombok.Data;

@Data
public class VideoProcessingDetailsDto {

    private String processingStatus;
    private VideoProcessingProgressDto processingProgress;
    private String processingFailureReason;
    private String fileDetailsAvailability;
    private String processingIssuesAvailability;
    private String tagSuggestionsAvailability;
    private String editorSuggestionsAvailability;
    private String thumbnailsAvailability;

}
