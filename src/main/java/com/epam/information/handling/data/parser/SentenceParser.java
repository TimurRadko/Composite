package com.epam.information.handling.data.parser;

import com.epam.information.handling.data.component.Component;
import com.epam.information.handling.data.component.Leaf;

import java.util.List;

public class SentenceParser extends AbstractParser {
    private static final String WORD = "(\\p{Graph}+ )|(\\p{Alnum}+[.!?])";
    private static final String EXPRESSION = "(\\d.+?[_+*/-])+ ";

    public SentenceParser(Parser successor) {
        super(successor);
    }

    @Override
    protected void process(List<Component> children, String value) {
        if (EXPRESSION.matches(value)) {
            Leaf expression = Leaf.createExpression(value);
            children.add(expression);
        } else {
            Leaf word = Leaf.createWord(value);
            children.add(word);
        }
    }

    @Override
    protected String getPattern() {
        return WORD;
    }
}
