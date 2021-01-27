package to.rxs.kore.integrations.clients.youtube.models.transfer;

import lombok.Data;

@Data
public class VideoContentDetailsDto {

    private String duration;
    private String dimension;
    private String definition;
    private String caption;
    private Boolean licensedContent;
    private VideoRegionRestrictionDto regionRestriction;
    private VideoContentRatingDto contentRating;
    private String projection;
    private Boolean hasCustomThumbnail;

}
