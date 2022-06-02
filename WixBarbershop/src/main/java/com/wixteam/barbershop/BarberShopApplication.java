package com.wixteam.barbershop;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import java.sql.SQLException;

@SpringBootApplication
@ImportResource("classpath:dependencies.xml")
public class BarberShopApplication {
    public static void main(String[] args) throws SQLException {
        SpringApplication sApp = new SpringApplication(BarberShopApplication.class);
        sApp.run(args);
    }
    @Bean
    public OpenAPI customOpenAPI(@Value("${application.name}") String appName,
                                 @Value("${application.description}") String description) {
        return new OpenAPI().components(new Components()).info( new Info().title(appName).description(description));
    }
}
