package com.epam.information.handling.data.parser;

public class ParagraphParser extends AbstractParser {
    private static final String PATTERN_SENTENCE = "[A-Z].*?[.!?](.|)";

    public ParagraphParser(Parser successor) {
        super(successor);
    }

    @Override
    protected String getPattern() {
        return PATTERN_SENTENCE;
    }
}
