package com.common.calculate.operation;

import com.common.calculate.CalculatorCommand;
import com.common.calculate.math.Calculator;

/**
 * 除法
 * @author ghosn
 */
public class DivideCommand implements CalculatorCommand {

    private Calculator calculator;

    private double value;

    public DivideCommand(Calculator calculator, double value) {
        this.calculator = calculator;
        this.value = value;
    }

    @Override
    public void execute() {
        calculator.setCurrentValue(calculator.getCurrentValue() / value);
    }

    @Override
    public void undo() {
        calculator.setCurrentValue(calculator.getCurrentValue() * value);
    }
}