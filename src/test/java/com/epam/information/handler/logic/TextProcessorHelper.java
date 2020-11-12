package com.epam.information.handler.logic;

import com.epam.information.handling.data.component.Component;
import com.epam.information.handling.data.component.Composite;
import com.epam.information.handling.data.component.Leaf;

import java.util.Arrays;

public class TextProcessorHelper {
    private static final Leaf FIRST_LEAF = Leaf.createWord("We ");
    private static final Leaf SECOND_LEAF = Leaf.createWord("[8]. ");
    private static final Leaf THIRD_LEAF = Leaf.createWord("Hello! ");

    public static Component getUnsortedTextForWordsSorting() {
        Component sentence = new Composite(Arrays.asList(THIRD_LEAF, SECOND_LEAF, FIRST_LEAF));
        Component paragraph = new Composite(Arrays.asList(sentence, sentence));
        return new Composite(Arrays.asList(paragraph, paragraph));
    }

    public static Component getUnsortedTextForParagraphSorting() {
        Component sentence = new Composite(Arrays.asList(THIRD_LEAF, SECOND_LEAF, FIRST_LEAF));
        Component twoParagraphs = new Composite(Arrays.asList(sentence, sentence));
        Component threeParagraphs = new Composite(Arrays.asList(sentence, sentence, sentence));
        return new Composite(Arrays.asList(threeParagraphs, twoParagraphs));

    }

    public static Component getSortedTextForWordsSorting() {
        Component sortedSentence = new Composite(Arrays.asList(FIRST_LEAF, SECOND_LEAF, THIRD_LEAF));
        Component sortedParagraph = new Composite(Arrays.asList(sortedSentence, sortedSentence));
        return new Composite(Arrays.asList(sortedParagraph, sortedParagraph));
    }

    public static Component getSortedBySentenceLengthText() {
        Component sentence = new Composite(Arrays.asList(THIRD_LEAF, SECOND_LEAF, FIRST_LEAF));
        Component twoParagraphs = new Composite(Arrays.asList(sentence, sentence));
        Component threeParagraphs = new Composite(Arrays.asList(sentence, sentence, sentence));
        return new Composite(Arrays.asList(twoParagraphs, threeParagraphs));
    }

    public static String getExpectedText() {
        return "Hello! [8]. We Hello! [8]. We \r\nHello! [8]. We Hello! [8]. We";
    }
}
