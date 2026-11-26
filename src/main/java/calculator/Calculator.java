package calculator;

/** Basic arithmetic: add, subtract, multiply and divide. */
public class Calculator {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    /** @throws ArithmeticException if {@code b} is zero */
    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    /**
     * Applies one of {@code + - * x /} to the two operands.
     *
     * @throws IllegalArgumentException if the operator is not supported
     */
    public double calculate(double a, String operator, double b) {
        switch (operator) {
            case "+":
                return add(a, b);
            case "-":
                return subtract(a, b);
            case "*":
            case "x":
                return multiply(a, b);
            case "/":
                return divide(a, b);
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
}
