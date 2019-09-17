package com.wkrzywiec.medium.nasapicture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@SpringBootApplication
public class NasapictureApplication extends SpringBootServletInitializer {
 
    @Override
    protected SpringApplicationBuilder configure(
      SpringApplicationBuilder builder) {
        return builder.sources(NasapictureApplication.class);
    }
 
    public static void main(String[] args) {
        SpringApplication sa = new SpringApplication(
          NasapictureApplication.class);
        sa.run(args);
    }
 
    @RestController
    public static class WarInitializerController {
 
        @GetMapping("/")
        public String handler() {
           // ...
           return "Hello";
        }
    }
}
