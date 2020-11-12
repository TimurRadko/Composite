package com.epam.information.handling.logic.expression;

public class TerminalExpressionMinus implements MathExpression {

    @Override
    public void interpret(Context context) {
        int secondNumber = context.popValue();
        int firstNumber = context.popValue();
        context.pushValue(firstNumber - secondNumber);
    }
}
