package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MathOperationsServiceTest {

    @Autowired
    private MathOperationsService mathOperationsService;

    @BeforeEach
    public void setUp() {
        // Any necessary setup can be done here
    }

    @Test
    public void testSumListWithPositiveNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Integer expectedSum = 15;
        Integer actualSum = mathOperationsService.sumList(numbers);
        assertEquals(expectedSum, actualSum, "The sum should be 15");
    }

    @Test
    public void testSumListWithNegativeNumbers() {
        List<Integer> numbers = Arrays.asList(-1, -2, -3, -4, -5);
        Integer expectedSum = -15;
        Integer actualSum = mathOperationsService.sumList(numbers);
        assertEquals(expectedSum, actualSum, "The sum should be -15");
    }

    @Test
    public void testSumListWithMixedNumbers() {
        List<Integer> numbers = Arrays.asList(-1, 2, -3, 4, -5);
        Integer expectedSum = -3;
        Integer actualSum = mathOperationsService.sumList(numbers);
        assertEquals(expectedSum, actualSum, "The sum should be -3");
    }

    @Test
    public void testSumListWithEmptyList() {
        List<Integer> numbers = Collections.emptyList();
        Integer expectedSum = 0;
        Integer actualSum = mathOperationsService.sumList(numbers);
        assertEquals(expectedSum, actualSum, "The sum of an empty list should be 0");
    }

    @Test
    public void testSumListWithSingleElement() {
        List<Integer> numbers = Collections.singletonList(5);
        Integer expectedSum = 5;
        Integer actualSum = mathOperationsService.sumList(numbers);
        assertEquals(expectedSum, actualSum, "The sum should be 5");
    }

    
    @Test
    public void testPlusPow2WithSingleElement() {
        List<Integer> numbers = Collections.singletonList(5);
        Integer expectedSum = 5;
        Integer actualSum = mathOperationsService.plusPow2(numbers);
        assertEquals(expectedSum, actualSum, "The sum should be 5");
    }
}
