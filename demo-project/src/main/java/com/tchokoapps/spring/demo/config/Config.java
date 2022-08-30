package com.tchokoapps.spring.demo.config;

import com.tchokoapps.spring.demo.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class Config {

    @Primary
    @Bean
    Vehicle vehicle() {
        return new Vehicle("Audi 8");
    }

    @Bean
    Vehicle vehicle2() {
        return new Vehicle("Honda");
    }

    @Bean
    Vehicle vehicle3() {
        return new Vehicle("Ferrari");
    }
}
