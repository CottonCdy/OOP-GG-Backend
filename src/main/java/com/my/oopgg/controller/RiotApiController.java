package com.my.oopgg.controller;

import com.my.oopgg.dto.riot.RiotSummonerDto;
import com.my.oopgg.service.RiotApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RiotApiController {

    private final RiotApiService riotApiService;

    public RiotApiController(RiotApiService riotApiService) {
        this.riotApiService = riotApiService;
    }

    // 1. 라이엇 name + tag로 puuid 얻기
    // 2. puuid로 계정 정보 불러오기
    @GetMapping("/riot/api/user-info")
    public String getSummonerInfo(@RequestParam String gameName, @RequestParam String tagLine) {
        RiotSummonerDto riotSummonerDto = riotApiService.getSummonerInfo(gameName, tagLine);
        return "";
    }
}
