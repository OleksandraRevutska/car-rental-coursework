package com.example.carrental.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI carRentalOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Система управління орендою автомобілів")
                        .version("1.0.0")
                        .description("""
                                REST API для управління системою оренди автомобілів.
                                Система дозволяє зберігати та обробляти інформацію про автомобілі,
                                клієнтів, договори оренди, категорії автомобілів та локації.
                                """)
                        .contact(new Contact()
                                .name("Кафедра інформаційних систем")
                                .email("9103053@stud.op.edu.ua")));
    }
}