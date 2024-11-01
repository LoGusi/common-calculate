package com.common.calculate.operation;

import com.common.calculate.CalculatorCommand;
import com.common.calculate.math.Calculator;

/**
 * 剑减法
 * @author ghosn
 */
public class SubtractCommand implements CalculatorCommand {

    private Calculator calculator;

    private double value;

    public SubtractCommand(Calculator calculator, double value) {
        this.calculator = calculator;
        this.value = value;
    }

    @Override
    public void execute() {
        calculator.setCurrentValue(calculator.getCurrentValue() - value);
    }

    @Override
    public void undo() {
        calculator.setCurrentValue(calculator.getCurrentValue() + value);
    }
}