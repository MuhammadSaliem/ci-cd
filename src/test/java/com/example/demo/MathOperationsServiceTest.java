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
    public void testMultipleList_WithPositiveNumbers() {
        // Test multiplying positive numbers
        Integer result = mathOperationsService.multipleList(Arrays.asList(2, 3, 4));
        assertEquals(24, result); // 2 * 3 * 4 = 24
    }

    @Test
    public void testMultipleList_WithNegativeNumbers() {
        // Test multiplying negative numbers
        Integer result = mathOperationsService.multipleList(Arrays.asList(-2, 3, 4));
        assertEquals(-24, result); // -2 * 3 * 4 = -24
    }

    @Test
    public void testMultipleList_WithZeros() {
        // Test multiplying numbers including zero
        Integer result = mathOperationsService.multipleList(Arrays.asList(2, 0, 4));
        assertEquals(0, result); // 2 * 0 * 4 = 0
    }

    @Test
    public void testMultipleList_SingleElement() {
        // Test multiplying a list with a single element
        Integer result = mathOperationsService.multipleList(Collections.singletonList(5));
        assertEquals(5, result); // Single element should return the element itself
    }

    @Test
    public void testMultipleList_EmptyList() {
        // Test multiplying an empty list
        Integer result = mathOperationsService.multipleList(Collections.emptyList());
        assertEquals(1, result); // Should return 1 since product of nothing is 1
    }

    @Test
    public void testMultipleList_WithAllNegativeNumbers() {
        // Test multiplying all negative numbers
        Integer result = mathOperationsService.multipleList(Arrays.asList(-1, -2, -3));
        assertEquals(-6, result); // -1 * -2 * -3 = -6
    }

}
