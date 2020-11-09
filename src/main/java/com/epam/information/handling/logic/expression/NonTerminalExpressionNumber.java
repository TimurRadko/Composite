package com.epam.information.handling.logic.expression;

import com.epam.information.handling.logic.Context;

public class NonTerminalExpressionNumber implements MathExpression {
    private final int value;

    public NonTerminalExpressionNumber(int value) {
        this.value = value;
    }

    @Override
    public void interpret(Context context) {
        context.pushValue(value);
    }
}
