package com.epam.information.handling.data.parser;

import java.util.regex.Pattern;

public class ParagraphParser extends AbstractParser {
    private static final String PATTERN_SENTENCE = "[A-Z].*?[.!?](.|)";

    public ParagraphParser(Parser successor) {
        super(successor);
    }

    @Override
    protected Pattern getPattern() {
        return Pattern.compile(PATTERN_SENTENCE);
    }
}
