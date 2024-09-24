package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @GetMapping("/hello")
    public String hello() {
        return "Hello there, World!!!";
    }

    @PostMapping("/sum")
    public Integer sumList(@RequestBody List<Integer> numList) {
        Integer sum = 0;

        for (int i = 0; i < numList.size(); i++) {
            sum += numList.get(i);
        }

        return sum;
    }

    @PostMapping("/divide")
    public Double divList(@RequestBody List<Integer> numList) {
        Double sum = 0.0;

        for (int i = 0; i < numList.size(); i++) {
            sum += numList.get(i);
        }

        return sum;
    }

    @PostMapping("/subract")
    public Double subList(@RequestBody List<Integer> numList) {
        Double sum = 0.0;

        for (int i = 0; i < numList.size(); i++) {
            sum += numList.get(i);
        }

        return sum;
    }

    @PostMapping("/multiple")
    public Double mulList(@RequestBody List<Integer> numList) {
        Double sum = 0.0;

        for (int i = 0; i < numList.size(); i++) {
            sum += numList.get(i);
        }

        return sum;
    }

    @PostMapping("/pow")
    public Double powList(@RequestBody List<Integer> numList) {
        Double sum = 0.0;

        for (int i = 0; i < numList.size(); i++) {
            sum += numList.get(i);
        }

        return sum;
    }
}