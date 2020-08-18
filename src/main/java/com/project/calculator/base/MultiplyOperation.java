package com.project.calculator.base;

public class MultiplyOperation implements IBinaryOperation { 
    @Override
    public double Calculate(double firstItem, double secondItem)
    { 
        System.out.println("Implements multiply operation"); 
        return firstItem * secondItem;
    } 
} 
