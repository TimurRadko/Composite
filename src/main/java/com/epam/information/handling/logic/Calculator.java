package com.epam.information.handling.logic;

import com.epam.information.handling.logic.expression.AbstractMathExpression;
import com.epam.information.handling.logic.expression.NonTerminalExpressionNumber;
import com.epam.information.handling.logic.expression.terminal.TerminalExpressionDivide;
import com.epam.information.handling.logic.expression.terminal.TerminalExpressionMinus;
import com.epam.information.handling.logic.expression.terminal.TerminalExpressionMultiply;
import com.epam.information.handling.logic.expression.terminal.TerminalExpressionPlus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {

    public int calculate(String expression) {
        List<AbstractMathExpression> mathExpressions = parse(expression);
        Context context = new Context();
        for (AbstractMathExpression terminal : mathExpressions) {
            terminal.interpret(context);
        }
        return context.popValue();
    }

    private List<AbstractMathExpression> parse(String expression) {
        List<AbstractMathExpression> mathExpressions = new ArrayList<>();
        String[] expressions = expression.split("\\p{Blank}+");
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
}

