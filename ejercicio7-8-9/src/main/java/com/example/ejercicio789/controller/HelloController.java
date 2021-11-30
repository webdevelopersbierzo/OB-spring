package com.example.ejercicio789.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/api/helloworld")
    public String helloworld(){
        return " Hola Mundo ";
    }
}
