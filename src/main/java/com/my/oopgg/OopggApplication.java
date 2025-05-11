package com.my.oopgg;

import com.my.oopgg.config.RiotApiProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class OopggApplication {

    public static void main(String[] args) {
        SpringApplication.run(OopggApplication.class, args);
    }

}
