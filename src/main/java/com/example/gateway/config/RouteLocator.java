package com.example.gateway.config;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RouteLocator {

    @Bean
    public org.springframework.cloud.gateway.route.RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("order-service", r ->
                        r.path("/orders")
                                .uri("http://localhost:8082")
                )
                .build();
    }
}
