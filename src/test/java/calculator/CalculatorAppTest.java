package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;

class CalculatorAppTest {

    private final CalculatorApp app = new CalculatorApp();

    @Test
    void evaluatesExpressions() {
        assertEquals("7", app.evaluate("3 + 4"));
        assertEquals("2.5", app.evaluate("  5   /  2 "));
        assertEquals("-6", app.evaluate("-2 x 3"));
    }

    @Test
    void reportsErrorsInsteadOfCrashing() {
        assertEquals("Error: Cannot divide by zero", app.evaluate("1 / 0"));
        assertEquals("Error: not a number", app.evaluate("a + 1"));
        assertEquals("Error: Unknown operator: %", app.evaluate("1 % 2"));
        assertTrue(app.evaluate("1 +").startsWith("Error: expected"));
    }

    @Test
    void runReadsLinesUntilQuit() throws Exception {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(bytes, true, StandardCharsets.UTF_8);

        app.run(new StringReader("2 * 3\n\nquit\n10 - 1\n"), out);

        String[] lines = bytes.toString(StandardCharsets.UTF_8).split("\\R");
        assertEquals(2, lines.length);
        assertEquals("6", lines[1]);
    }
}
