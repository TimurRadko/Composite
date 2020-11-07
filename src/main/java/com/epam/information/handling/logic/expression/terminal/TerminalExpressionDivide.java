package com.epam.information.handling.logic.expression.terminal;

import com.epam.information.handling.logic.Context;
import com.epam.information.handling.logic.expression.AbstractMathExpression;

public class TerminalExpressionDivide extends AbstractMathExpression {

    @Override
    public void interpret(Context context) {
        int secondNumber = context.popValue();
        int firstNumber = context.popValue();
        context.pushValue(firstNumber / secondNumber);
    }
}
