package com.project.calculator.model;

import com.project.calculator.base.CalcType;

public class CalcResult {

    private double result;
    private CalcType operation;
    private double first;
    private double second;

    public CalcResult(double result, CalcType operation, double first, double second) {
        this.result = result;
        this.operation = operation;
        this.first = first;
        this.second = second;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public CalcType getOperation() {
        return operation;
    }

    public void setOperation(CalcType operation) {
        this.operation = operation;
    }

    public double getFirst() {
        return first;
    }

    public void setFirst(double first) {
        this.first = first;
    }

    public double getSecond() {
        return second;
    }

    public void setSecond(double second) {
        this.second = second;
    }

}