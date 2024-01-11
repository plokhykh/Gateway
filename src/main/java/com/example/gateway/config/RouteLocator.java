package com.example.gateway.config;

import com.example.gateway.filters.AuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RouteLocator {

    AuthenticationFilter filter;

    @Bean
    public org.springframework.cloud.gateway.route.RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("order-service", r ->
                        r.path("/order/**")
                                .filters(f -> f.filter(filter))
                                .uri("/order")
                )
                .build();
    }
}
