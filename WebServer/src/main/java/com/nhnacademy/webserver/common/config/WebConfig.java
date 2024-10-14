package com.nhnacademy.webserver.common.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // static view
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login/index");
        registry.addViewController("/signon").setViewName("signon/index");
        registry.addViewController("/project/new").setViewName("project/form");
    }

    // rest template
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplateBuilder().build();
    }
}
