package net.springboot.learning.flightsmonitoring.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Чтобы инъектировать ObjectMapper в любую часть проекта,
 * я добавил создание и добавление его в ApplicationContext через конфигурационный класс.
 * аннотация @Configuration говорит Spring’у, что в этом классе будут какие-то конфигурации.
 * И как раз для этого добавлен ObjectMapper.
 */
/**
 * {@link Configuration} class.
 */
@Configuration
public class Config {
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }
}
