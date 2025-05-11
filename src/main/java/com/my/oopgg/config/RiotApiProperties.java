package com.my.oopgg.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "riot")
@Getter
@Setter
public class RiotApiProperties {
    private String apiKey;
    private String baseUrlAsia;
    private String baseUrlKr;

    private String endpointAccountByRiotId;
    private String endpointSummonerByPuuid;
    private String endpointTierByPuuid;
}
