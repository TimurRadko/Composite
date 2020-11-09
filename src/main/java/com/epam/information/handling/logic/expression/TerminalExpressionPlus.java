package com.epam.information.handling.logic.expression;

import com.epam.information.handling.logic.Context;

public class TerminalExpressionPlus implements MathExpression {

    @Override
    public void interpret(Context context) {
        int firstNumber = context.popValue();
        int secondNumber = context.popValue();
        context.pushValue(firstNumber + secondNumber);
    }
}
