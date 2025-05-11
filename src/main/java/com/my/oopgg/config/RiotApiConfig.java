package com.my.oopgg.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RiotApiConfig {
    private final RiotApiProperties riotApiProperties;

    public RiotApiConfig(RiotApiProperties riotApiProperties) {
        this.riotApiProperties = riotApiProperties;
    }

    @Bean
    public RestTemplate riotRestTemplate(RestTemplateBuilder builder) {
        return builder
                .defaultHeader("X-Riot-Token", riotApiProperties.getApiKey())
                .build();
    }
}
