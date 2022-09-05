package com.example.movie.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/hello")
    public Object SayHello(){
        return "hello world";
    }

}
