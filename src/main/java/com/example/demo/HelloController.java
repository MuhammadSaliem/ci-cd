package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private MathOperationsService mathOperationsService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello there, World!";
    }

    @GetMapping("/sum")
    public Integer sumList(@RequestBody List<Integer> numList) {
        return mathOperationsService.sumList(numList);
    }
}
