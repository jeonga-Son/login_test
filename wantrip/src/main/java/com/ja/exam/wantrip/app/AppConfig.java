package com.ja.exam.wantrip.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Getter
    private static ApplicationContext context;

    @Autowired
    public void setContext(ApplicationContext context) {
        AppConfig.context = context;
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper().registerModule(new JavaTimeModule()); // JavaTimeModule() 은 LocalDateTime 직렬화 역직렬화 오류 때문에 쓰임
    }
}