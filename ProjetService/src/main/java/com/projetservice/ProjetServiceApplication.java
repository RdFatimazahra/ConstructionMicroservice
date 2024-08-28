package com.projetservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ProjetServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetServiceApplication.class, args);
    }

}
