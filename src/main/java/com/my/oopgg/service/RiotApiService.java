package com.my.oopgg.service;

import com.my.oopgg.config.RiotApiProperties;
import com.my.oopgg.dto.riot.RiotSummonerDto;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Iterator;
import java.util.Map;

@Service
public class RiotApiService {

    private final RestTemplate riotRestTemplate;
    private final RiotApiProperties riotApiProperties;

    public RiotApiService(RestTemplate riotRestTemplate,  RiotApiProperties riotApiProperties) {
        this.riotRestTemplate = riotRestTemplate;
        this.riotApiProperties = riotApiProperties;
    }

    public RiotSummonerDto getSummonerInfo(String gameName, String tagLine) {
        // 1. Riot ID로 계정 정보 가져오기
        String accountUrl = String.format("%s/%s/%s/%s",
                riotApiProperties.getBaseUrlAsia(),
                riotApiProperties.getEndpointAccountByRiotId(),
                gameName,
                tagLine);

        ResponseEntity<Map> response = riotRestTemplate.exchange(accountUrl, HttpMethod.GET, null, Map.class);
        Map<String, Object> accountInfo = response.getBody();

        // 2. 소환사 정보 가져오기
        String puuid = (String) accountInfo.get("puuid");
        String sumonnerUrl = String.format("%s/%s/%s",
                riotApiProperties.getBaseUrlKr(),
                riotApiProperties.getEndpointSummonerByPuuid(),
                puuid);

        response = riotRestTemplate.exchange(sumonnerUrl, HttpMethod.GET, null, Map.class);
        Map<String, Object> sumonnerInfo = response.getBody();

        // 3. 티어 정보 가져오기
        String TierUrl = String.format("%s/%s/%s",
                riotApiProperties.getBaseUrlKr(),
                riotApiProperties.getEndpointTierByPuuid(),
                puuid);
        
//        response = riotRestTemplate.exchange(TierUrl, HttpMethod.GET, null, Map.class);
//        List<Map<String, Object>> TierInfo = response.getBody();

        return new RiotSummonerDto(
                (String) accountInfo.get("getName"),
                (String) accountInfo.get("tagLine"),
                (Integer) sumonnerInfo.get("profileIconId"),
                (Integer) sumonnerInfo.get("summonerLevel")
        );
    }
}