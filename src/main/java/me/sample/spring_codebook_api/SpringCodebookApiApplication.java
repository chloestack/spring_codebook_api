package me.sample.spring_codebook_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringCodebookApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCodebookApiApplication.class, args);
    }

}
