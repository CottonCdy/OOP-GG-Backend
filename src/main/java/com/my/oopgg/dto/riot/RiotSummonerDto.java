package com.my.oopgg.dto.riot;

import lombok.Getter;

import java.util.Map;
import java.util.Objects;

@Getter
public class RiotSummonerDto {
    private String name;
    private String tagLine;
    private Integer profileIconId;
    private Integer level;

//    private Map<String, Object> rankTier;

    public RiotSummonerDto(String getName,
                           String tagLine,
                           Integer profileIconId,
                           Integer summonerLevel) {
        this.name = getName;
        this.tagLine = tagLine;
        this.level = summonerLevel;
        this.profileIconId = profileIconId;
    }

//    public class RankTier {
//        private String queueType;
//        private String tier;
//        private String rank;
//        private int leaguePoints;
//        private int wins;
//        private int losses;
//
//        public RankTier(String queueType, String tier, String rank, int leaguePoints, int wins, int losses) {
//            this.queueType = queueType;
//            this.tier = tier;
//            this.rank = rank;
//            this.leaguePoints = leaguePoints;
//            this.wins = wins;
//            this.losses = losses;
//        }
//    }
}