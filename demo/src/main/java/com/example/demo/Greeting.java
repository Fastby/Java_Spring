package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@ConfigurationProperties(prefix = "greeting")
public class Greeting {
    private String name;
    private String id;

    public String getName(){ return name;}
    public void setName(String name){ this.name = name; }
    public String getId(){return id;}
    public void setId(String id){this.id = id;}
}
