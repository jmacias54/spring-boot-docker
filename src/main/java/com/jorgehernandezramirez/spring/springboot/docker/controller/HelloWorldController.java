package com.jorgehernandezramirez.spring.springboot.docker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public String doHelloWorld() {
        return "Hello World!";
    }
}
