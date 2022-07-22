package com.ejercicio456.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/api/hola")
    public String hola(){
        return "Helloo!";
    }
}
