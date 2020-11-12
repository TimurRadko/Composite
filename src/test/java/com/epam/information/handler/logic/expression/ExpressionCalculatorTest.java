package com.epam.information.handler.logic.expression;

import com.epam.information.handling.logic.expression.ExpressionCalculator;
import org.junit.Assert;
import org.junit.Test;

public class ExpressionCalculatorTest {
    private static final String MULTIPLY = "2_5_* ";
    private static final String PLUS = "2_5_+ ";
    private static final String MINUS = "10_5_- ";
    private static final String DIVIDE = "10_5_/ ";

    @Test
    public void testCalculateShouldReturnCorrectAnswerWhenUsingMultiply() {
        ExpressionCalculator expressionCalculator = new ExpressionCalculator();
        int result = expressionCalculator.calculate(MULTIPLY);
        Assert.assertEquals(10, result);
    }

    @Test
    public void testCalculateShouldReturnCorrectAnswerWhenUsingPlus() {
        ExpressionCalculator expressionCalculator = new ExpressionCalculator();
        int result = expressionCalculator.calculate(PLUS);
        Assert.assertEquals(7, result);
    }

    @Test
    public void testCalculateShouldReturnCorrectAnswerWhenUsingMinus() {
        ExpressionCalculator expressionCalculator = new ExpressionCalculator();
        int result = expressionCalculator.calculate(MINUS);
        Assert.assertEquals(5, result);
    }

    @Test
    public void testCalculateShouldReturnCorrectAnswerWhenUsingDivide() {
        ExpressionCalculator expressionCalculator = new ExpressionCalculator();
        int result = expressionCalculator.calculate(DIVIDE);
        Assert.assertEquals(2, result);
    }
}
