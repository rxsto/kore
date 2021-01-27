package to.rxs.kore.integrations.clients.youtube.models.transfer;

import lombok.Data;

import java.util.List;

@Data
public class VideoFileDetailsDto {

    private String fileName;
    private Long fileSize;
    private String fileType;
    private String container;
    private List<VideoStreamDto> videoStreams;
    private List<AudioStreamDto> audioStreams;
    private Long durationMs;
    private Long bitrateBps;
    private String creationTime;

}
