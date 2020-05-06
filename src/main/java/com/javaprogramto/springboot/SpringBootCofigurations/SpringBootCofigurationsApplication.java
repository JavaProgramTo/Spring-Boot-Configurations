package com.javaprogramto.springboot.SpringBootCofigurations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class SpringBootCofigurationsApplication {

    public static void main(String[] args) {


       // SpringApplication.run(SpringBootCofigurationsApplication.class, args);

        SpringApplication app = new SpringApplication(SpringBootCofigurationsApplication.class);

        Map<String, Object> customConfig = new HashMap<>();
        customConfig.put("server.port", "9009");

       // app.setDefaultProperties(customConfig);

        app.run(args);

    }


}
