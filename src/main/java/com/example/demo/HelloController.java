package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello there, World!!";
    }

    @GetMapping("/sum")
    public Integer sumList(@RequestBody List<Integer> numList) {
        Integer sum = 0;

        for(int i = 0; i < numList.size(); i++)
        {
            sum += numList.get(i);
        }

        return sum;
    }
}
