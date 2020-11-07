package com.epam.information.handling.data.parser;

import com.epam.information.handling.data.component.Component;
import com.epam.information.handling.data.component.Composite;

public class TextParser extends AbstractParser {
    private static final String PARAGRAPH_SEPARATOR = "\n";

    @Override
    public Component parse(String text) {
        String[] nodes = text.split(PARAGRAPH_SEPARATOR);
        Component component = new Composite();
        Parser successor = getSuccessor();
        for (String node : nodes) {
            Component child = successor.parse(node);
            component.add(child);
        }
        return component;
    }
}
