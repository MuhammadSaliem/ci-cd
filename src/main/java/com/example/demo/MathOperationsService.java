package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MathOperationsService {

    // Sum of all elements in the list
    public Integer sumList(List<Integer> numList) {
        Integer sum = 0; // To store the result

        for (int i = 0; i < numList.size(); i++) {
            sum += numList.get(i);
        }

        return sum;
    }

    // Multiplication of all elements in the list
    public Integer multipleList(List<Integer> numList) {
        Integer product = 1; // Initialized to 1 to handle multiplication

        for (int i = 0; i < numList.size(); i++) {
            product *= numList.get(i);
        }

        return product;
    }

    // Adding all elements in the list and multiplying each by 2
    public Integer plusPow2(List<Integer> numList) {
        Integer sum = 0; // To store the result

        for (int i = 0; i < numList.size(); i++) {
            sum += numList.get(i) * 2;
        }

        return sum;
    }

    // Subtraction of all elements in the list
    public Integer subtractList(List<Integer> numList) {
        if (numList.isEmpty()) {
            return 0;
        }

        Integer result = numList.get(0); // Start with the first element

        for (int i = 1; i < numList.size(); i++) {
            result -= numList.get(i);
        }

        return result;
    }

    // Division of all elements in the list
    public Double divideList(List<Integer> numList) {
        if (numList.isEmpty() || numList.contains(0)) {
            throw new IllegalArgumentException("Cannot divide by zero or an empty list.");
        }

        Double result = numList.get(0).doubleValue(); // Start with the first element

        for (int i = 1; i < numList.size(); i++) {
            result /= numList.get(i);
        }

        return result;
    }

    // Modulus of all elements in the list
    public Integer modulusList(List<Integer> numList) {
        if (numList.isEmpty()) {
            return 0; // Return 0 for an empty list
        }

        Integer result = numList.get(0); // Start with the first element

        for (int i = 1; i < numList.size(); i++) {
            if (numList.get(i) == 0) {
                throw new IllegalArgumentException("Cannot perform modulus with zero.");
            }
            result %= numList.get(i);
        }

        return result;
    }
}
