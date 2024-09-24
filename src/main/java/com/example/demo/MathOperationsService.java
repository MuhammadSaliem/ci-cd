package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MathOperationsService {

    public Integer sumList(List<Integer> numList) {
        Integer sum = 0; // To store the result

        for (int i = 0; i < numList.size(); i++) {
            sum += numList.get(i);
        }

        return sum;
    }

    public Integer mulitpleList(List<Integer> numList) {
        Integer sum = 0; // To store the result

        for (int i = 0; i < numList.size(); i++) {
            sum *= numList.get(i);
        }

        return sum;
    }

    public Integer plusPow2(List<Integer> numList) {
        Integer sum = 0; // To store the result

        for (int i = 0; i < numList.size(); i++) {
            sum += numList.get(i) * 2; // this comment should cause issue in sonarcloud
        }

        return sum;
    }
}
