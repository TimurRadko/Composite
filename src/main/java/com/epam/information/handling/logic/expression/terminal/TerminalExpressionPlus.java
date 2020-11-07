package com.epam.information.handling.logic.expression.terminal;

import com.epam.information.handling.logic.Context;
import com.epam.information.handling.logic.expression.AbstractMathExpression;

public class TerminalExpressionPlus extends AbstractMathExpression {

    @Override
    public void interpret(Context context) {
        int firstNumber = context.popValue();
        int secondNumber = context.popValue();
        context.pushValue(firstNumber + secondNumber);
    }
}
