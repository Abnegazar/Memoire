package com.memoire.wohaya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class WohayaApplication {

    @GetMapping("/")
    public String hello(){
        return "Hello world !";
    }

    public static void main(String[] args) {
        SpringApplication.run(WohayaApplication.class, args);
    }
}
