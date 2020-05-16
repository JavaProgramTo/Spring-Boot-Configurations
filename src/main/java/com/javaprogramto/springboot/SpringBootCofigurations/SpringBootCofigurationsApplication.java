package com.javaprogramto.springboot.SpringBootCofigurations;

import com.javaprogramto.packagee.one.EmployeeOne;
import com.javaprogramto.packagee.three.EmployeeThree;
import com.javaprogramto.packagee.two.EmployeeTwo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
//@ComponentScan({"com.javaprogramto.packagee.one", "com.javaprogramto.packagee.two"})
@ComponentScan(basePackages = {"com.javaprogramto.packagee.one", "com.javaprogramto.packagee.two"})
public class SpringBootCofigurationsApplication {

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(SpringBootCofigurationsApplication.class);

        Map<String, Object> customConfig = new HashMap<>();
        customConfig.put("server.port", "9009");

        ApplicationContext context = app.run(args);
        EmployeeOne e = (EmployeeOne) context.getBean("employeeOne");
        System.out.println("EmployeeOne bean : " + e);

        EmployeeTwo e2 = (EmployeeTwo) context.getBean("employeeTwo");
        System.out.println("EmployeeTwo bean : " + e2);

        EmployeeThree e3 = (EmployeeThree) context.getBean("employeeThree");
        System.out.println("EmployeeThree bean : " + e3);

    }

}
