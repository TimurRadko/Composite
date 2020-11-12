package com.epam.information.handling.data.parser;

public class TextParser extends AbstractParser {
    private static final String PATTERN_PARAGRAPH = "(\\p{Graph}* .*)|(\\p{Graph}*.)";

    public TextParser(Parser successor) {
        super(successor);
    }

    @Override
    protected String getPattern() {
        return PATTERN_PARAGRAPH;
    }
}
