package com.epam.information.handling.data.parser;

public class ChainBuilder {

    public Parser build() {
        SentenceParser sentenceParser = new SentenceParser(null);
        ParagraphParser paragraphParser = new ParagraphParser(sentenceParser);
        return new TextParser(paragraphParser);
    }
}
