package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    public void testMultipleListWithPositiveNumbers() {
        // Test multiplying positive numbers
        Integer result = mathOperationsService.multipleList(Arrays.asList(2, 3, 4));
        assertEquals(24, result); // 2 * 3 * 4 = 24
    }

    @Test
    public void testMultipleListWithNegativeNumbers() {
        // Test multiplying negative numbers
        Integer result = mathOperationsService.multipleList(Arrays.asList(-2, 3, 4));
        assertEquals(-24, result); // -2 * 3 * 4 = -24
    }

    @Test
    public void testMultipleListWithZeros() {
        // Test multiplying numbers including zero
        Integer result = mathOperationsService.multipleList(Arrays.asList(2, 0, 4));
        assertEquals(0, result); // 2 * 0 * 4 = 0
    }

    @Test
    public void testMultipleListSingleElement() {
        // Test multiplying a list with a single element
        Integer result = mathOperationsService.multipleList(Collections.singletonList(5));
        assertEquals(5, result); // Single element should return the element itself
    }

    @Test
    public void testMultipleListEmptyList() {
        // Test multiplying an empty list
        Integer result = mathOperationsService.multipleList(Collections.emptyList());
        assertEquals(1, result); // Should return 1 since product of nothing is 1
    }

    @Test
    public void testMultipleListWithAllNegativeNumbers() {
        // Test multiplying all negative numbers
        Integer result = mathOperationsService.multipleList(Arrays.asList(-1, -2, -3));
        assertEquals(-6, result); // -1 * -2 * -3 = -6
    }

    @Test
    public void testPlusPow2() {
        // Test with a normal list of integers
        List<Integer> numList = Arrays.asList(1, 2, 3);
        assertEquals(12, mathOperationsService.plusPow2(numList));

        // Test with an empty list
        numList = Arrays.asList();
        assertEquals(0, mathOperationsService.plusPow2(numList));

        // Test with negative numbers
        numList = Arrays.asList(-1, -2, -3);
        assertEquals(-12, mathOperationsService.plusPow2(numList));

        // Test with a mix of positive and negative numbers
        numList = Arrays.asList(-1, 2, 3);
        assertEquals(8, mathOperationsService.plusPow2(numList));
    }

    @Test
    public void testSubtractList() {
        // Test with a normal list of integers
        List<Integer> numList = Arrays.asList(10, 2, 3);
        assertEquals(5, mathOperationsService.subtractList(numList));

        // Test with an empty list
        numList = Arrays.asList();
        assertEquals(0, mathOperationsService.subtractList(numList));

        // Test with negative numbers
        numList = Arrays.asList(-1, -2, -3);
        assertEquals(4, mathOperationsService.subtractList(numList));

        // Test with a single element
        numList = Arrays.asList(5);
        assertEquals(5, mathOperationsService.subtractList(numList));
    }

    @Test
    public void testDivideList() {
        // Test with a normal list of integers
        List<Integer> numList = Arrays.asList(10, 2, 5);
        assertEquals(1.0, mathOperationsService.divideList(numList));

        // Test with an empty list
        final List<Integer> emptyList = Arrays.asList();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            mathOperationsService.divideList(emptyList);
        });

        // Test with one element
        numList = Arrays.asList(10);
        assertEquals(10.0, mathOperationsService.divideList(numList));

        // Test with zero in the list - Uncomment this when the exception handling is
        // added
        /*
         * numList = Arrays.asList(10, 0);
         * assertThrows(IllegalArgumentException.class, () -> {
         * mathOperationsService.divideList(numList);
         * });
         */

        // Test with negative numbers
        numList = Arrays.asList(-10, -2);
        assertEquals(5.0, mathOperationsService.divideList(numList));
    }

    @Test
    public void testModulusList_WithValidInput() {
        // Test with a normal list of integers
        assertEquals(0, mathOperationsService.modulusList(Arrays.asList(10, 2, 3))); // 10 % 2 = 0
        assertEquals(1, mathOperationsService.modulusList(Arrays.asList(10, 3, 2))); // 10 % 3 = 1
        assertEquals(0, mathOperationsService.modulusList(Arrays.asList(10, 5, 5))); // 10 % 5 = 0
        assertEquals(2, mathOperationsService.modulusList(Arrays.asList(17, 5, 3))); // 17 % 5 = 2
    }

    @Test
    public void testModulusList_WithEmptyList() {
        // Test with an empty list
        assertEquals(0, mathOperationsService.modulusList(Arrays.asList())); // Should return 0
    }

    @Test
    public void testModulusList_WithSingleElement() {
        // Test with a single-element list
        assertEquals(5, mathOperationsService.modulusList(Arrays.asList(5))); // Should return 5
        assertEquals(10, mathOperationsService.modulusList(Arrays.asList(10))); // Should return 10
    }

    @Test
    public void testModulusList_WithZeroInList() {
        // Test with a list that includes zero
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            mathOperationsService.modulusList(Arrays.asList(10, 0)); // Should throw exception
        });
        assertEquals("Cannot perform modulus with zero.", thrown.getMessage());
    }

    @Test
    public void testModulusList_WithNegativeNumbers() {
        // Test with negative numbers
        assertEquals(-1, mathOperationsService.modulusList(Arrays.asList(-10, 3))); // -10 % 3 = -1
        assertEquals(0, mathOperationsService.modulusList(Arrays.asList(-10, -5))); // -10 % -5 = 0
    }

}
