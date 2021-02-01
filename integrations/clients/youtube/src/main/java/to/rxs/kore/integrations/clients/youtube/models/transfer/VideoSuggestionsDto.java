package to.rxs.kore.integrations.clients.youtube.models.transfer;

import lombok.Data;

import java.util.List;

@Data
public class VideoSuggestionsDto {

    private List<String> processingErrors;
    private List<String> processingWarnings;
    private List<String> processingHints;
    private List<VideoTagSuggestionDto> tagSuggestions;
    private List<String> editorSuggestions;

}
