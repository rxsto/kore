package to.rxs.kore.integrations.clients.youtube.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import to.rxs.kore.integrations.clients.youtube.models.transfer.ResourceDto;
import to.rxs.kore.integrations.clients.youtube.models.transfer.SearchResultDto;
import to.rxs.kore.integrations.clients.youtube.models.transfer.VideoDto;

import java.io.IOException;
import java.util.Map;

public class ResourceDeserializer extends JsonDeserializer<ResourceDto> {

    private static final Map<String, Class<? extends ResourceDto>> CLASSES = Map.of(
            "searchResult", SearchResultDto.class,
            "video", VideoDto.class
    );

    @Override
    public ResourceDto deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode json = p.readValueAsTree();

        // Find kind of resource and strip 'youtube#' from its value
        var kind = json.get("kind").asText().substring(8);
        var clazz = CLASSES.get(kind);

        if (clazz == null) {
            throw new RuntimeException(String.format("Failed deserializing resource '%s' since its kind is unknown!", kind));
        }

        return p.getCodec().treeToValue(json, clazz);
    }

}
