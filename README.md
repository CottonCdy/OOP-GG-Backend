# OOP-GG-Backend
리그 오브 레전드 API를 이용한 정보 사이트입니다.


## Feature
### 전적 검색
🟦 소환사 이름 + 태그로 검색<br>

### 게임 일기장
🟦 나의 게임에 대해 일기 작성<br>

### 챔피언 분류
🟦 내가 자주 사용하는 챔피언 분류<br>

### 커뮤니티
🟦 게시판

## 기술 스택
### Language
🟩 Java 21<br>

### Framework
🟩 Spring Boot<br>
🟩 Spring Data JPA<br>
🟩 Spring Validation<br>
🟩 Spring Security<br>

### Database
🟩 Mysql<br>
🟩 Redis<br>

---

## ERD
```mermaid
erDiagram
    USERS {
        int id PK
        string email
        string password
        string username
        datetime created_at
        datetime updated_at
    }

    SUMMONERS {
        int id PK
        int user_id FK
        string summoner_name
        string puuid
        boolean is_verified
        string region
        datetime created_at
        datetime updated_at
    }
    
    GAME_JOURNALS {
        int id PK
        int summoner_id FK
        string match_id
        string champion_name
        text mistakes
        text lessons
        text next_goal
        text memo
        boolean is_public
        datetime created_at
        datetime updated_at
    }
    
    CHAMPION_TAGS {
        int id PK
        int summoner_id FK
        string name
        datetime created_at
        datetime updated_at
    }

    USER_CHAMPION_TAGS {
        int id PK
        int tag_id FK
        int champion_id
        string champion_name
        text memo
        datetime created_at
        datetime updated_at
    }
    
    LOL_PERSONALITY {
        int id PK
        int summoner_id FK
        string personality_code
        string title
        text description
        datetime created_at
        datetime updated_at
    }
    
    BOARD {
        int id PK
        int user_id FK
        int board_id
        bool allow_comments
        bool announcement
        datetime created_at
        datetime updated_at
    }
    
    USERS ||--o{ SUMMONERS : ""
    USERS ||--o{ BOARD : ""
    SUMMONERS ||--o{ CHAMPION_TAGS : ""
    SUMMONERS ||--o{ GAME_JOURNALS : ""
    SUMMONERS ||--o{ LOL_PERSONALITY : ""
    CHAMPION_TAGS ||--o{ USER_CHAMPION_TAGS : ""