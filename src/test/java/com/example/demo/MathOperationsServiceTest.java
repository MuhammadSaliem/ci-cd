package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MathOperationsServiceTest {

    private MathOperationsService mathOperationsService;

    @BeforeEach
    public void setUp() {
        // Instantiate the service directly since we are testing the actual service methods
        mathOperationsService = new MathOperationsService();
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
    public void testMultipleListWithPositiveNumbers() {
        Integer result = mathOperationsService.multipleList(Arrays.asList(2, 3, 4));
        assertEquals(24, result); // 2 * 3 * 4 = 24
    }

    @Test
    public void testMultipleListWithNegativeNumbers() {
        Integer result = mathOperationsService.multipleList(Arrays.asList(-2, 3, 4));
        assertEquals(-24, result); // -2 * 3 * 4 = -24
    }

    @Test
    public void testMultipleListWithZeros() {
        Integer result = mathOperationsService.multipleList(Arrays.asList(2, 0, 4));
        assertEquals(0, result); // 2 * 0 * 4 = 0
    }

    @Test
    public void testPlusPow2() {
        List<Integer> numList = Arrays.asList(1, 2, 3);
        assertEquals(12, mathOperationsService.plusPow2(numList));

        numList = Arrays.asList();
        assertEquals(0, mathOperationsService.plusPow2(numList));

        numList = Arrays.asList(-1, -2, -3);
        assertEquals(-12, mathOperationsService.plusPow2(numList));
    }

    @Test
    public void testSubtractList() {
        List<Integer> numList = Arrays.asList(10, 2, 3);
        assertEquals(5, mathOperationsService.subtractList(numList));

        numList = Arrays.asList();
        assertEquals(0, mathOperationsService.subtractList(numList));
    }

    @Test
    public void testDivideList() {
        List<Integer> numList = Arrays.asList(10, 2, 5);
        assertEquals(1.0, mathOperationsService.divideList(numList));

        numList = Arrays.asList(10);
        assertEquals(10.0, mathOperationsService.divideList(numList));
    }

    @Test
    public void testModulusList_WithValidInput() {
        assertEquals(0, mathOperationsService.modulusList(Arrays.asList(10, 2, 3)));
        assertEquals(1, mathOperationsService.modulusList(Arrays.asList(10, 3, 2)));
    }

    @Test
    public void testModulusList_WithZeroInList() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            mathOperationsService.modulusList(Arrays.asList(10, 0));
        });
        assertEquals("Cannot perform modulus with zero.", thrown.getMessage());
    }
}
