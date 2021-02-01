package to.rxs.kore.integrations.clients.youtube.deser;

import com.fasterxml.jackson.databind.module.SimpleModule;
import to.rxs.kore.integrations.clients.youtube.models.transfer.ResourceDto;

public class YouTubeResourceModule extends SimpleModule {

    public YouTubeResourceModule() {
        addDeserializer(ResourceDto.class, new ResourceDeserializer());
    }

}
