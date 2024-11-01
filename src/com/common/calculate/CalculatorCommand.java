package com.common.calculate;

/**
 *
 * @author ghosn
 */
public interface CalculatorCommand {
    /**
     * 执行方法
     */
    void execute();

    /**
     * 撤销方法
     */
    void undo();
}
