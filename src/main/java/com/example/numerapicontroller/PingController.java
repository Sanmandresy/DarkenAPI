package com.example.numerapicontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {
    @GetMapping("/")
    public String Response(){
        return "Hello from the API.";
    }
}
