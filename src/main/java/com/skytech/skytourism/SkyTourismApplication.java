package com.skytech.skytourism;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.skytech.application.idgen"})
public class SkyTourismApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkyTourismApplication.class, args);
    }
}
