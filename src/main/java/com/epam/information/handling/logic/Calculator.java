package com.epam.information.handling.logic;

import com.epam.information.handling.logic.expression.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {

    public int calculate(String expression) {
        String preparedExpression = prepareStringValue(expression);
        List<AbstractMathExpression> mathExpressions = parse(preparedExpression);
        Context context = new Context();
        for (AbstractMathExpression terminal : mathExpressions) {
            terminal.interpret(context);
        }
        return context.popValue();
    }

    private List<AbstractMathExpression> parse(String expression) {
        List<AbstractMathExpression> mathExpressions = new ArrayList<>();
        String[] expressions = expression.split("_");
        for (String lexeme : expressions) {
            if (lexeme.isEmpty()) {
                continue;
            }
            char temp = lexeme.charAt(0);
            switch (temp) {
                case '+':
                    TerminalExpressionPlus plus = new TerminalExpressionPlus();
                    mathExpressions.add(plus);
                    break;
                case '-':
                    TerminalExpressionMinus minus = new TerminalExpressionMinus();
                    mathExpressions.add(minus);
                    break;
                case '*':
                    TerminalExpressionMultiply multiply = new TerminalExpressionMultiply();
                    mathExpressions.add(multiply);
                    break;
                case '/':
                    TerminalExpressionDivide divide = new TerminalExpressionDivide();
                    mathExpressions.add(divide);
                    break;
                default:
                    Scanner scanner = new Scanner(lexeme);
                    if (scanner.hasNextInt()) {
                        int number = scanner.nextInt();
                        NonTerminalExpressionNumber nonTerminalExpression = new NonTerminalExpressionNumber(number);
                        mathExpressions.add(nonTerminalExpression);
                    }
            }
        }
        return mathExpressions;
    }

    private String prepareStringValue(String expression) {
        int length = expression.length();
        return expression.substring(1, length - 2);
    }
}

