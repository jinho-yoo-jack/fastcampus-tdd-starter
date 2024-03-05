package com.fastcamp.tddstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class TddStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(TddStarterApplication.class, args);
    }

}
