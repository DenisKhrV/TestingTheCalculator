package pro.sky.calculator.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.calculator.TestUtils;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceImplParametrizedTest {

    private final CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();

    public static Stream<Arguments> plusParams() {
        return Stream.of(
                Arguments.of("2", "2", TestUtils.formatResult(2, 2, "+", String.valueOf(2 + 2))),
                Arguments.of("-3", "-3", TestUtils.formatResult(-3, -3, "+", String.valueOf(-3 + -3))),
                Arguments.of("-4", "4", TestUtils.formatResult(-4, 4, "+", String.valueOf(-4 + 4)))
        );
    }

    @ParameterizedTest
    @MethodSource("plusParams")
    void plus(int num1, int num2, String result) {
        assertEquals(result, calculatorService.plus(num1, num2));
    }

    public static Stream<Arguments> minusParams() {
        return Stream.of(
                Arguments.of("2", "1", TestUtils.formatResult(2, 1, "-", String.valueOf(2 - 1))),
                Arguments.of("-5", "-3", TestUtils.formatResult(-5, -3, "-", String.valueOf(-5 - -3))),
                Arguments.of("-4", "4", TestUtils.formatResult(-4, 4, "-", String.valueOf(-4 - 4)))
        );
    }

    @ParameterizedTest
    @MethodSource("minusParams")
    void minus(int num1, int num2, String result) {
        assertEquals(result, calculatorService.minus(num1, num2));
    }

    public static Stream<Arguments> multiplyParams() {
        return Stream.of(
                Arguments.of("2", "4", TestUtils.formatResult(2, 4, "*", String.valueOf(2 * 4))),
                Arguments.of("-5", "-3", TestUtils.formatResult(-5, -3, "*", String.valueOf(-5 * -3))),
                Arguments.of("-4", "4", TestUtils.formatResult(-4, 4, "*", String.valueOf(-4 * 4)))
        );
    }

    @ParameterizedTest
    @MethodSource("multiplyParams")
    void multiply(int num1, int num2, String result) {
        assertEquals(result, calculatorService.multiply(num1, num2));
    }

    public static Stream<Arguments> divideParams() {
        return Stream.of(
                Arguments.of("10", "2", TestUtils.formatResult(10, 2, "/", String.valueOf((double) 10 / 2))),
                Arguments.of("-5", "-2", TestUtils.formatResult(-5, -2, "/", String.valueOf((double) -5 / -2))),
                Arguments.of("-10", "3", TestUtils.formatResult(-10, 3, "/", String.valueOf((double) -10 / 3)))
        );
    }

    @ParameterizedTest
    @MethodSource("divideParams")
    void divide(int num1, int num2, String result) {
        assertEquals(result, calculatorService.divide(num1, num2));
    }
}