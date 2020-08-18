package com.project.calculator.base;

public class FactoryOperation {
    public IBinaryOperation buildOperation(CalcType calcType) {
        IBinaryOperation operation = null;
        switch (calcType) {
            case ADD:
                operation = new AddOperation();
                break;
            case SUBTRACT:
                operation = new SubtractOperation();
                break;
            case MULTIPLY:
                operation = new MultiplyOperation();
                break;
            default:
                break;
        }
        return operation;
    }

    public static double makeOperation(CalcType calcType, double dblFirst, double dblSecond) {

        FactoryOperation factoryOperation = new FactoryOperation();
        IBinaryOperation operation = factoryOperation.buildOperation(calcType);
        return operation.Calculate(dblFirst, dblSecond);
    }
}
