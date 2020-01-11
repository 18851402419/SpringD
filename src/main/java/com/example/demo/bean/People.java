package com.example.demo.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
//@PropertySource("application.yml")
@ConfigurationProperties(prefix = "people")
/**
 * 这个People的bean需要放到与HelloController同一个包下
 */
public class People {
    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    private String height;
    private String name;
    private String age;
}
