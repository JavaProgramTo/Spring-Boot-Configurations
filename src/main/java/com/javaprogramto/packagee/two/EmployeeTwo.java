package com.javaprogramto.packagee.two;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;


@ComponentScan(basePackages = "com.javaprogramto.packagee.three")
@Component
public class EmployeeTwo {

    private int id;
    private String name;
}
