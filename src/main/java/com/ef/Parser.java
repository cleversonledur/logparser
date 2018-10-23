package com.ef;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.ef.service.ParserService;

@SpringBootApplication public class Parser {

    public static void main(String[] args) throws Exception {

        System.setProperty("spring.config.name", "application");
        try (final ConfigurableApplicationContext applicationContext = SpringApplication.run(Parser.class, args)) {
            applicationContext.getBean(ParserService.class).run(args);
        }
    }

    @Bean
    ParserService parserService() {
        return new ParserService();
    }

}
