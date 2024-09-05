package com.gatewayservice.config;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {


//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }
//}
    @Bean
    public HttpMessageConverters customConverters() {
        // You can add custom converters here if needed
        return new HttpMessageConverters();
    }
}
