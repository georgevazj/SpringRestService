package com.bbva.lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.*;

/**
 * Created by jorge on 01/12/2016.
 */

@SpringBootApplication
public class Launcher {

    public static void main(String[] args){
        SpringApplication.run(Launcher.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry corsRegistry) {
                corsRegistry.addMapping("/quote").allowedOrigins("*");
                corsRegistry.addMapping("/quote/*").allowedOrigins("*");
                corsRegistry.addMapping("/hash").allowedOrigins("*");
            }
        };
    }

}
