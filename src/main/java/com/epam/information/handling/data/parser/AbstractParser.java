package com.epam.information.handling.data.parser;

import com.epam.information.handling.data.component.Component;
import com.epam.information.handling.data.component.Composite;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractParser implements Parser {
    private final Parser successor;

    public AbstractParser(Parser successor) {
        this.successor = successor;
    }

    public Component parse(String text) {
        String patternString = getPattern();
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);
        List<Component> children = new ArrayList<>();
        while (matcher.find()) {
            String value = matcher.group();
            process(children, value);
        }
        return new Composite(children);
    }

    protected void process(List<Component> children, String value) {
        Component child = successor.parse(value);
        children.add(child);
    }

    protected abstract String getPattern();
}
