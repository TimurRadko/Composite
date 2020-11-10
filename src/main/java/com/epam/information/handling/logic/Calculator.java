package com.epam.information.handling.logic;

import com.epam.information.handling.logic.expression.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {

    public int calculate(String expression) {
        String preparedExpression = expression.trim();
        List<MathExpression> mathExpressions = parse(preparedExpression);
        Context context = new Context();
        for (MathExpression terminal : mathExpressions) {
            terminal.interpret(context);
        }
        return context.popValue();
    }

    private List<MathExpression> parse(String expression) {
        List<MathExpression> mathExpressions = new ArrayList<>();
        String[] expressions = expression.split("_");
        for (String lexeme : expressions) {
            if (lexeme.isEmpty()) {
                continue;
            }
            char temp = lexeme.charAt(0);
            switch (temp) {
                case '+':
                    mathExpressions.add(new TerminalExpressionPlus());
                    break;
                case '-':
                    mathExpressions.add(new TerminalExpressionMinus());
                    break;
                case '*':
                    mathExpressions.add(new TerminalExpressionMultiply());
                    break;
                case '/':
                    mathExpressions.add(new TerminalExpressionDivide());
                    break;
                default:
                    Scanner scanner = new Scanner(lexeme);
                    if (scanner.hasNextInt()) {
                        int number = scanner.nextInt();
                        mathExpressions.add(new NonTerminalExpressionNumber(number));
                    }
            }
        }
        return mathExpressions;
    }
}

