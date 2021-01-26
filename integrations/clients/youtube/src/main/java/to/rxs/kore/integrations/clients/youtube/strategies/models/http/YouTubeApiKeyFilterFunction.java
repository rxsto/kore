package to.rxs.kore.integrations.clients.youtube.strategies.models.http;

import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;

public class YouTubeApiKeyFilterFunction implements ExchangeFilterFunction {

    private final String youTubeApiKey;

    public YouTubeApiKeyFilterFunction(String youTubeApiKey) {
        this.youTubeApiKey = youTubeApiKey;
    }

    @Override
    public Mono<ClientResponse> filter(ClientRequest request, ExchangeFunction next) {
        var url = UriComponentsBuilder.fromUri(request.url())
                .queryParam("key", youTubeApiKey)
                .build()
                .toUriString();

        var filteredRequest = ClientRequest.from(request)
                .url(URI.create(url))
                .build();

        return next.exchange(filteredRequest);
    }
}
