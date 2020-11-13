package com.epam.information.handling.logic.expression;

public class TerminalExpressionPlus implements MathExpression {

    @Override
    public void interpret(Context context) {
        int firstNumber = context.popValue();
        int secondNumber = context.popValue();
        context.pushValue(firstNumber + secondNumber);
    }
}
