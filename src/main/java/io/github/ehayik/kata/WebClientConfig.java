package io.github.ehayik.kata;

import static io.netty.handler.logging.LogLevel.DEBUG;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static reactor.netty.transport.logging.AdvancedByteBufFormat.TEXTUAL;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@Configuration
class WebClientConfig {

    private static final String FAKE_BEARER_TOKEN =
            "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";

    @Bean
    public ReactorClientHttpConnector wiretappedConnector() {
        var httpClient = HttpClient.create().wiretap("http.clients.users-client", DEBUG, TEXTUAL);
        return new ReactorClientHttpConnector(httpClient);
    }

    @Bean("users-client.WebClient")
    public WebClient usersWebClient(
            WebClient.Builder webClientBuilder, ReactorClientHttpConnector reactorClientHttpConnector) {
        return webClientBuilder
                .clientConnector(reactorClientHttpConnector)
                .baseUrl("https://fakerapi.it")
                .defaultHeader(AUTHORIZATION, FAKE_BEARER_TOKEN)
                .build();
    }
}
