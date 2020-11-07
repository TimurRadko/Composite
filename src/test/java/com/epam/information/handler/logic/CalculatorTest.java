package com.epam.information.handler.logic;

import com.epam.information.handling.logic.Calculator;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    private static final String EXPRESSION = "2 5 * 4 +";

    @Test
    public void testCalculateShouldReturnCorrectAnswerWhen() {
        Calculator calculator = new Calculator();
        int result = calculator.calculate(EXPRESSION);
        Assert.assertEquals(14, result);
    }


}
