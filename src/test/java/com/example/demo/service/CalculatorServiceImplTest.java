package com.example.demo.service;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorServiceImplTest {

    public CalculatorServiceImplTest() {

    }

    @Test
   public void testSumofNumbers_empty(){
        CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
        int actualResult = calculatorService.sumOfNumbers();
        int expectedResult = 0;
        assertEquals(expectedResult,actualResult);

   }
}
