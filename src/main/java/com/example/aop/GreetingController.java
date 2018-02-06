package com.example.aop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Logged
@RestController
public class GreetingController {

    @GetMapping
    public String greeting(@RequestParam(defaultValue = "Bob") String name) {
        return "hello " + name;
    }
}
