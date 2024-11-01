import com.common.calculate.math.Calculator;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(10);
        calculator.add(10);
        calculator.subtract(3);
        calculator.multiply(2);
        calculator.divide(4);

        calculator.undo();
        calculator.undo();
        calculator.redo();
    }
}