package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void addsNumbers() {
        assertEquals(7, calculator.add(3, 4));
        assertEquals(-1.5, calculator.add(-2, 0.5));
    }

    @Test
    void subtractsNumbers() {
        assertEquals(-1, calculator.subtract(3, 4));
    }

    @Test
    void multipliesNumbers() {
        assertEquals(12, calculator.multiply(3, 4));
        assertEquals(0, calculator.multiply(5, 0));
    }

    @Test
    void dividesNumbers() {
        assertEquals(2.5, calculator.divide(5, 2));
    }

    @Test
    void divisionByZeroThrows() {
        ArithmeticException e = assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));
        assertEquals("Cannot divide by zero", e.getMessage());
    }

    @Test
    void calculateDispatchesOnOperator() {
        assertEquals(7, calculator.calculate(3, "+", 4));
        assertEquals(-1, calculator.calculate(3, "-", 4));
        assertEquals(12, calculator.calculate(3, "*", 4));
        assertEquals(12, calculator.calculate(3, "x", 4));
        assertEquals(0.75, calculator.calculate(3, "/", 4));
    }

    @Test
    void unknownOperatorThrows() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(3, "%", 4));
    }
}
