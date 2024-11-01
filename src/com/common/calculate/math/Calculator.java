package com.common.calculate.math;

import com.common.calculate.CalculatorCommand;
import com.common.calculate.operation.AddCommand;
import com.common.calculate.operation.SubtractCommand;
import com.common.calculate.operation.MultiplyCommand;
import com.common.calculate.operation.DivideCommand;

import java.util.Stack;

/**
 * 模拟计算器
 * @author ghosn
 */
public class Calculator {

    private double currentValue = 0;

    /**
     * 存储历史计算记录
     */
    private Stack<CalculatorCommand> history = new Stack<>();

    /**
     * 存储上一步操作
     */
    private Stack<CalculatorCommand> redoStack = new Stack<>();

    public double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(double value) {
        currentValue = value;
    }

    public Calculator(double currentValue) {
        this.currentValue = currentValue;
    }

    private void executeCommand(CalculatorCommand command) {
        command.execute();
        history.push(command);
        redoStack.clear(); // 执行新命令后，清空重做栈
    }

    public void add(double value) {
        executeCommand(new AddCommand(this, value));
        System.out.println("Added " + value + ", Current Value: " + currentValue);
    }

    public void subtract(double value) {
        executeCommand(new SubtractCommand(this, value));
        System.out.println("Subtracted " + value + ", Current Value: " + currentValue);
    }

    public void multiply(double value) {
        executeCommand(new MultiplyCommand(this, value));
        System.out.println("Multiplied by " + value + ", Current Value: " + currentValue);
    }

    public void divide(double value) {
        if (value == 0) {
            System.out.println("Cannot divide by zero!");
            return;
        }
        executeCommand(new DivideCommand(this, value));
        System.out.println("Divided by " + value + ", Current Value: " + currentValue);
    }

    public void undo() {
        if (history.isEmpty()) {
            System.out.println("Nothing to undo!");
            return;
        }
        CalculatorCommand lastCommand = history.pop();
        lastCommand.undo();
        redoStack.push(lastCommand);
        System.out.println("Undo performed, Current Value: " + currentValue);
    }

    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Nothing to redo!");
            return;
        }
        CalculatorCommand command = redoStack.pop();
        command.execute();
        history.push(command);
        System.out.println("Redo performed, Current Value: " + currentValue);
    }
}
