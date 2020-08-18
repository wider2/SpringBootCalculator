package com.project.calculator.base;

public class AddOperation implements IBinaryOperation { 
    @Override
    public double Calculate(double firstItem, double secondItem)
    { 
        System.out.println("Implements addition operation"); 
        return firstItem + secondItem;
    } 
} 
