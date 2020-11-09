package com.epam.information.handling.data.parser;

import java.util.regex.Pattern;

public class TextParser extends AbstractParser {
    private static final String PATTERN_PARAGRAPH = "(\\p{Alpha}+\\p{Punct}* .*)|(\\p{Alpha}+.)";

    public TextParser(Parser successor) {
        super(successor);
    }

    @Override
    protected Pattern getPattern() {
        return Pattern.compile(PATTERN_PARAGRAPH);
    }
}
