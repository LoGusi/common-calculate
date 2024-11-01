package com.common.calculate.operation;

import com.common.calculate.CalculatorCommand;
import com.common.calculate.math.Calculator;

/**
 * 加法
 * @author ghosn
 */
public class AddCommand implements CalculatorCommand {

    private Calculator calculator;

    private double value;

    public AddCommand(Calculator calculator, double value) {
        this.calculator = calculator;
        this.value = value;
    }

    @Override
    public void execute() {
        calculator.setCurrentValue(calculator.getCurrentValue() + value);
    }

    @Override
    public void undo() {
        calculator.setCurrentValue(calculator.getCurrentValue() - value);
    }
}