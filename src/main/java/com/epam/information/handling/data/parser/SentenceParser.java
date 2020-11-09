package com.epam.information.handling.data.parser;

import com.epam.information.handling.data.component.Component;
import com.epam.information.handling.data.component.Composite;
import com.epam.information.handling.data.component.Leaf;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SentenceParser extends AbstractParser {
    private static final String WORD = "(\\p{Graph}+ )|(\\p{Alnum}+[.!?])";
    private static final String EXPRESSION = "\\[.+?] ";

    public SentenceParser(Parser successor) {
        super(successor);
    }

    public Component parse(String text) {
        Pattern pattern = getPattern();
        Matcher matcherWord = pattern.matcher(text);
        List<Component> lexemes = new ArrayList<>();
        while (matcherWord.find()) {
            String value = matcherWord.group();
            if (value.matches(EXPRESSION)) {
                Leaf expression = Leaf.createExpression(value);
                lexemes.add(expression);
            } else {
                Leaf word = Leaf.createWord(value);
                lexemes.add(word);
            }
        }
        return new Composite(lexemes);
    }

    @Override
    protected Pattern getPattern() {
        return Pattern.compile(WORD);
    }
}
