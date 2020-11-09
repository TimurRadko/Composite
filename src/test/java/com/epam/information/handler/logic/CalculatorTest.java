package com.epam.information.handler.logic;

import com.epam.information.handling.logic.Calculator;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    private static final String MULTIPLY = "[2_5_*] ";
    private static final String PLUS = "[2_5_+] ";
    private static final String MINUS = "[10_5_-] ";
    private static final String DIVIDE = "[10_5_/] ";

    @Test
    public void testCalculateShouldReturnCorrectAnswerWhenUsingMultiply() {
        Calculator calculator = new Calculator();
        int result = calculator.calculate(MULTIPLY);
        Assert.assertEquals(10, result);
    }

    @Test
    public void testCalculateShouldReturnCorrectAnswerWhenUsingPlus() {
        Calculator calculator = new Calculator();
        int result = calculator.calculate(PLUS);
        Assert.assertEquals(7, result);
    }

    @Test
    public void testCalculateShouldReturnCorrectAnswerWhenUsingMinus() {
        Calculator calculator = new Calculator();
        int result = calculator.calculate(MINUS);
        Assert.assertEquals(5, result);
    }

    @Test
    public void testCalculateShouldReturnCorrectAnswerWhenUsingDivide() {
        Calculator calculator = new Calculator();
        int result = calculator.calculate(DIVIDE);
        Assert.assertEquals(2, result);
    }
}
