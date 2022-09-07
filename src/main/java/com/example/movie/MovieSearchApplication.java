package com.example.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
@EnableJpaAuditing
public class MovieSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieSearchApplication.class, args);
    }

}
