package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MathOperationsServiceTest {
    private MathOperationsService mathOperationsService;

    @BeforeEach
    public void setUp() {
        mathOperationsService = new MathOperationsService();
    }

    @Test
    public void testSumList() {
        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(15, mathOperationsService.sumList(numList));

        List<Integer> emptyList = Collections.emptyList();
        assertEquals(0, mathOperationsService.sumList(emptyList));
    }

    @Test
    public void testMultipleList() {
        List<Integer> numList = Arrays.asList(1, 2, 3, 4);
        assertEquals(24, mathOperationsService.multipleList(numList));

        List<Integer> emptyList = Collections.emptyList();
        assertEquals(1, mathOperationsService.multipleList(emptyList));
    }

    @Test
    public void testPlusPow2() {
        List<Integer> numList = Arrays.asList(1, 2, 3);
        assertEquals(12, mathOperationsService.plusPow2(numList));

        List<Integer> emptyList = Collections.emptyList();
        assertEquals(0, mathOperationsService.plusPow2(emptyList));
    }

    @Test
    public void testSubtractList() {
        List<Integer> numList = Arrays.asList(10, 3, 2);
        assertEquals(5, mathOperationsService.subtractList(numList));

        List<Integer> emptyList = Collections.emptyList();
        assertEquals(0, mathOperationsService.subtractList(emptyList));

        List<Integer> singleElementList = Arrays.asList(10);
        assertEquals(10, mathOperationsService.subtractList(singleElementList));
    }

    @Test
    public void testDivideList() {
        List<Integer> numList = Arrays.asList(100, 5, 2);
        assertEquals(10.0, mathOperationsService.divideList(numList), 0.001);

        List<Integer> singleElementList = Arrays.asList(10);
        assertEquals(10.0, mathOperationsService.divideList(singleElementList), 0.001);
    }

    @Test
    public void testDivideListThrowsExceptionOnZeroDivision() {
        List<Integer> numListWithZero = Arrays.asList(100, 0, 5);
        assertThrows(IllegalArgumentException.class, () -> mathOperationsService.divideList(numListWithZero));
    }

    @Test
    public void testModulusList() {
        List<Integer> numList = Arrays.asList(10, 3, 2);
        assertEquals(1, mathOperationsService.modulusList(numList));

        List<Integer> emptyList = Collections.emptyList();
        assertEquals(0, mathOperationsService.modulusList(emptyList));
    }

    @Test
    public void testModulusListThrowsExceptionOnZeroModulus() {
        List<Integer> numListWithZero = Arrays.asList(10, 0);
        assertThrows(IllegalArgumentException.class, () -> mathOperationsService.modulusList(numListWithZero));
    }
}
