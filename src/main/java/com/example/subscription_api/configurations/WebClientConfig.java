package com.example.subscription_api.configurations;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Objects;

@Configuration
@AllArgsConstructor
public class WebClientConfig {
    private final Environment env;

    @Bean
    public WebClient MobilePaymentServiceWebClient() {
        return WebClient.builder()
                .baseUrl(Objects.requireNonNull(env.getProperty("mobile.payment.api.base-url")))
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}

