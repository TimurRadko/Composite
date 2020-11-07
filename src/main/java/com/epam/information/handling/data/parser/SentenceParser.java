package com.epam.information.handling.data.parser;

import com.epam.information.handling.data.component.Component;
import com.epam.information.handling.data.component.Composite;
import com.epam.information.handling.data.component.Leaf;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SentenceParser extends AbstractParser {
    private static final String WORD = "(\\p{Alpha}+\\p{Punct}|\\p{Alpha}+)|\\[\\d.+?[+*/-]]";
    private static final Pattern PATTERN_WORD = Pattern.compile(WORD);
    private static final String EXPRESSION = "\\[\\d.+?[+*/-]]";

    public Component parse(String text) {
        Matcher matcherWord = PATTERN_WORD.matcher(text);
        Component component = new Composite();
        while (matcherWord.find()) {
            String value = matcherWord.group();
            if (value.matches(EXPRESSION)) {
                Leaf expression = Leaf.createExpression(value);
                component.add(expression);
            } else {
                Leaf word = Leaf.createWord(value);
                component.add(word);
            }
        }
        return component;
    }
}
