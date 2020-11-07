package com.epam.information.handling.data.parser;

import com.epam.information.handling.data.component.Component;
import com.epam.information.handling.data.component.Composite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser extends AbstractParser {
    private static final String PATTERN_SENTENCE = "[A-Z].*?[.!?]";
    private static final Pattern PATTERN = Pattern.compile(PATTERN_SENTENCE);

    @Override
    public Component parse(String text) {
        Matcher matcher = PATTERN.matcher(text);
        Parser successor = getSuccessor();
        Component component = new Composite();
        while (matcher.find()) {
            String sentence = matcher.group();
            Component child = successor.parse(sentence);
            component.add(child);
        }
        return component;
    }

}
