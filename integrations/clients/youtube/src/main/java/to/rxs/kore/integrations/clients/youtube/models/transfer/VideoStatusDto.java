package to.rxs.kore.integrations.clients.youtube.models.transfer;

import lombok.Data;

@Data
public class VideoStatusDto {

    private String uploadStatus;
    private String failureReason;
    private String rejectionReason;
    private String privacyStatus;
    private String publishAt;
    private String license;
    private Boolean embeddable;
    private Boolean publicStatsViewable;
    private Boolean madeForKids;
    private Boolean selfDeclaredMadeForKids;

}
