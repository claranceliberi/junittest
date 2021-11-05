package com.example.demo.service;

public class CalculatorServiceImpl implements CalculatorService {
    public int sumOfNumbers(){
        int sum =0;

        for(int value:this.getAll()){
            sum += value;
        }

        return sum;
    }

    public int[] getAll(){
        return new int[] { 1, 2, 3 };
    }

}
