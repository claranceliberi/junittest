package com.example.demo.service;

public class CalculatorServiceImpl {
    public int sumOfNumbers(int[] data){
        int sum =0;

        for(int value:data){
            sum += value;
        }

        return sum;
    }


}
