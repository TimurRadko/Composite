package com.epam.information.handling.data.parser;

public class ChainBuilder {

    public Parser build() {
        TextParser textParser = new TextParser();
        ParagraphParser paragraphParser = new ParagraphParser();
        SentenceParser sentenceParser = new SentenceParser();
        textParser.setSuccessor(paragraphParser);
        paragraphParser.setSuccessor(sentenceParser);
       return textParser;
    }
}
