# calculator

A simple command-line calculator in Java that can add, subtract, multiply and divide numbers.

## Requirements

- Java 17+
- Maven 3.8+

## Build and test

```bash
mvn verify
```

## Run

```bash
mvn package
java -jar target/calculator-1.0.0-SNAPSHOT.jar
```

Type one expression per line, with spaces around the operator:

```
3 + 4
7
5 / 2
2.5
1 / 0
Error: Cannot divide by zero
quit
```

Supported operators: `+`, `-`, `*` (or `x`), `/`.

## Project layout

- `src/main/java/calculator/Calculator.java` – the arithmetic
- `src/main/java/calculator/CalculatorApp.java` – the command-line interface
- `src/test/java/calculator/` – JUnit 5 tests

CI runs `mvn -B verify` on Java 17 for every push to `master` and every pull request.
