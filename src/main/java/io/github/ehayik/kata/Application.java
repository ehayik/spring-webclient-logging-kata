package io.github.ehayik.kata;

import java.time.Duration;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UsersClient usersClient) {
        return args -> {
            MDC.put("traceId", UUID.randomUUID().toString().replace("-", ""));
            usersClient
                    .getUsers(1, "male")
                    .delayElement(Duration.ofMillis(1))
                    .map(UsersClient.ResponsePayload::data)
                    .doOnNext(x -> log.info("Users: {}", x))
                    .subscribe();
        };
    }
}
