package pro.sky.calculator.service;

import org.junit.jupiter.api.Test;
import pro.sky.calculator.TestUtils;
import pro.sky.calculator.exceptions.DivisionByZeroException;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceImplTest {
    private final CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();

    @Test
    void hello_success() {
        //Подготовка ожидаемого результата
        String expected = "Добро пожаловать в калькулятор";

        //Начало теста
        String actual = calculatorService.hello();
        assertEquals(expected, actual);
    }

    @Test
    void plus_success() {
        //Подготовка входных данных
        int num1 = 3;
        int num2 = 4;

        //Подготовка ожидаемого результата
        String expected = TestUtils.formatResult(num1, num2, "+", String.valueOf((num1 + num2)));

        //Начало теста
        String actual = calculatorService.plus(num1, num2);
        assertEquals(expected, actual);
    }

    @Test
    void plus_success2() {
        //Подготовка входных данных
        int num1 = 31;
        int num2 = 24;

        //Подготовка ожидаемого результата
        String expected = TestUtils.formatResult(num1, num2, "+", String.valueOf((num1 + num2)));

        //Начало теста
        String actual = calculatorService.plus(num1, num2);
        assertEquals(expected, actual);
    }

    @Test
    void minus_success() {
        //Подготовка входных данных
        int num1 = 21;
        int num2 = 4;

        //Подготовка ожидаемого результата
        String expected = TestUtils.formatResult(num1, num2, "-", String.valueOf((num1 - num2)));

        //Начало теста
        String actual = calculatorService.minus(num1, num2);
        assertEquals(expected, actual);
    }

    @Test
    void minus_success2() {
        //Подготовка входных данных
        int num1 = 51;
        int num2 = 14;

        //Подготовка ожидаемого результата
        String expected = TestUtils.formatResult(num1, num2, "-", String.valueOf((num1 - num2)));

        //Начало теста
        String actual = calculatorService.minus(num1, num2);
        assertEquals(expected, actual);
    }

    @Test
    void multiply_success() {
        //Подготовка входных данных
        int num1 = 4;
        int num2 = 5;

        //Подготовка ожидаемого результата
        String expected = TestUtils.formatResult(num1, num2, "*", String.valueOf((num1 * num2)));

        //Начало теста
        String actual = calculatorService.multiply(num1, num2);
        assertEquals(expected, actual);
    }

    @Test
    void multiply_success2() {
        //Подготовка входных данных
        int num1 = 14;
        int num2 = 15;

        //Подготовка ожидаемого результата
        String expected = TestUtils.formatResult(num1, num2, "*", String.valueOf((num1 * num2)));

        //Начало теста
        String actual = calculatorService.multiply(num1, num2);
        assertEquals(expected, actual);
    }

    @Test
    void divide_success1() {
        //Подготовка входных данных
        int num1 = 30;
        int num2 = 15;

        //Подготовка ожидаемого результата
        String expected = TestUtils.formatResult(num1, num2, "/", String.valueOf((double) num1 / num2));

        //Начало теста
        String actual = calculatorService.divide(num1, num2);
        assertEquals(expected, actual);
    }

    @Test
    void divide_success2() {
        //Подготовка входных данных
        int num1 = 10;
        int num2 = 4;

        //Подготовка ожидаемого результата
        String expected = TestUtils.formatResult(num1, num2, "/", String.valueOf((double) num1 / num2));

        //Начало теста
        String actual = calculatorService.divide(num1, num2);
        assertEquals(expected, actual);
    }

    @Test
    void divide_withException() {
        //Подготовка входных данных
        int num1 = 10;
        int num2 = 0;
        //Подготовка ожидаемого результата
        String expected = "На ноль делить нельзя!";

        //Начало теста
        Exception exception = assertThrows(
                DivisionByZeroException.class,
                () -> calculatorService.divide(num1, num2)
        );
        assertEquals(expected, exception.getMessage());
    }
}