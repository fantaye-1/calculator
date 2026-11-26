package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

/**
 * Command-line calculator. Type expressions like {@code 12 / 4} (spaces between
 * numbers and the operator), one per line. Type {@code quit} to exit.
 */
public class CalculatorApp {

    private final Calculator calculator = new Calculator();

    public static void main(String[] args) throws IOException {
        new CalculatorApp().run(new InputStreamReader(System.in, StandardCharsets.UTF_8), System.out);
    }

    void run(Reader input, PrintStream out) throws IOException {
        out.println("Enter an expression like: 3 + 4   (operators: + - * x /, 'quit' to exit)");
        BufferedReader reader = new BufferedReader(input);
        String line;
        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) {
                continue;
            }
            if (line.equalsIgnoreCase("quit") || line.equalsIgnoreCase("exit")) {
                break;
            }
            out.println(evaluate(line));
        }
    }

    /** Evaluates one "number operator number" line and returns the result or an error message. */
    String evaluate(String line) {
        String[] parts = line.trim().split("\\s+");
        if (parts.length != 3) {
            return "Error: expected <number> <operator> <number>, e.g. 3 + 4";
        }
        try {
            double a = Double.parseDouble(parts[0]);
            double b = Double.parseDouble(parts[2]);
            return format(calculator.calculate(a, parts[1], b));
        } catch (NumberFormatException e) {
            return "Error: not a number";
        } catch (ArithmeticException | IllegalArgumentException e) {
            return "Error: " + e.getMessage();
        }
    }

    /** Prints whole numbers without a trailing ".0". */
    static String format(double value) {
        if (value == Math.rint(value) && !Double.isInfinite(value) && Math.abs(value) < 1e15) {
            return String.valueOf((long) value);
        }
        return String.valueOf(value);
    }
}
