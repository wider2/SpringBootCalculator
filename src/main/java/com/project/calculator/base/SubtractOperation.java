package com.project.calculator.base;

public class SubtractOperation implements IBinaryOperation { 
    @Override
    public double Calculate(double firstItem, double secondItem)
    { 
        System.out.println("Implements subtract operation"); 
        return firstItem - secondItem;
    } 
} 
