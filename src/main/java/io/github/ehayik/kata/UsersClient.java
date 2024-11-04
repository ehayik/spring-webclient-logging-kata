package io.github.ehayik.kata;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.maciejwalkowiak.spring.http.annotation.HttpClient;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import reactor.core.publisher.Mono;

@HttpClient("users-client")
public interface UsersClient {

    @GetExchange("/api/v2/users")
    Mono<ResponsePayload> getUsers(@RequestParam("_quantity") int quantity, @RequestParam("_gender") String gender);

    record ResponsePayload(String status, int total, List<UserDetails> data) {}

    record UserDetails(
            @JsonProperty("firstname") String firstName,
            @JsonProperty("lastname") String lastName,
            String username,
            String password) {}
}
