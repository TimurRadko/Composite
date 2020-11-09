package com.epam.information.handler.logic;

import com.epam.information.handling.data.component.Component;
import com.epam.information.handling.data.component.Composite;
import com.epam.information.handling.data.component.Leaf;
import com.epam.information.handling.logic.TextProcessor;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class TextProcessorTest {
    private static final Leaf EXPECTED_WORD_LEAF = Leaf.createWord("Hello ");
    private static final Component EXPECTED_COMPONENT = new Composite(Collections.singletonList(EXPECTED_WORD_LEAF));
    private static final Component LEAF = Leaf.createExpression("[5_3_+] ");
    private static final Component EXPECTED_EXPRESSION_LEAF = Leaf.createWord("[8] ");
    private static final Component SENTENCE_COMPONENT = new Composite(Arrays.asList(EXPECTED_WORD_LEAF, EXPECTED_EXPRESSION_LEAF));
    private static final Component PARAGRAPH_COMPONENT = new Composite(Arrays.asList(SENTENCE_COMPONENT, SENTENCE_COMPONENT));
    private static final Component EXPECTED_TEXT = new Composite(Arrays.asList(PARAGRAPH_COMPONENT, PARAGRAPH_COMPONENT));

    private static final String EXPECTED_TEXT_STRING = "Hello [8] Hello [8] \r\nHello [8] Hello [8] ";

    private static final Component FIRST_PARAGRAPH_COMPONENT_FOR_SORTING =
            new Composite(Arrays.asList(SENTENCE_COMPONENT, SENTENCE_COMPONENT));
    private static final Component SECOND_PARAGRAPH_COMPONENT_FOR_SORTING =
            new Composite(Collections.singletonList(SENTENCE_COMPONENT));
    private static final Component UNSORTED_TEXT_FOR_SORTING =
            new Composite(Arrays.asList(FIRST_PARAGRAPH_COMPONENT_FOR_SORTING,
                    SECOND_PARAGRAPH_COMPONENT_FOR_SORTING));
    private static final Component SORTED_TEXT_FOR_SORTING =
            new Composite(Arrays.asList(SECOND_PARAGRAPH_COMPONENT_FOR_SORTING,
                    FIRST_PARAGRAPH_COMPONENT_FOR_SORTING));

    @Test
    public void testCalculateMathExpressionShouldReturnWordLeafWhenComponentHasNoChildren() {
        TextProcessor processor = new TextProcessor();
        Component actualLeaf = processor.calculateMathExpression(EXPECTED_WORD_LEAF);
        Assert.assertEquals(EXPECTED_WORD_LEAF, actualLeaf);
    }

    @Test
    public void testCalculateMathExpressionShouldReturnComponentWhenComponentHasChild() {
        TextProcessor processor = new TextProcessor();
        Component actualComponent = processor.calculateMathExpression(EXPECTED_COMPONENT);
        Assert.assertEquals(EXPECTED_COMPONENT, actualComponent);
    }

    @Test
    public void testResolveMathExpressionsShouldReturnCorrectAnswerWhenComponentIsExpression() {
        TextProcessor processor = new TextProcessor();
        Component actualLeaf = processor.calculateMathExpression(LEAF);
        Assert.assertEquals(EXPECTED_EXPRESSION_LEAF, actualLeaf);
    }

    @Test
    public void testRestoreTextShouldReturnRestoredTextWhenComponentIsText() {
        TextProcessor processor = new TextProcessor();
        String actualString = processor.restoreText(EXPECTED_TEXT);
        Assert.assertEquals(EXPECTED_TEXT_STRING, actualString);
    }

    @Test
    public void testSortParagraphsBySentenceLengthShouldReturnSortedText() {
        TextProcessor processor = new TextProcessor();
        Component actualComponent = processor.sortParagraphsBySentenceLength(UNSORTED_TEXT_FOR_SORTING);
        Assert.assertEquals(SORTED_TEXT_FOR_SORTING, actualComponent);
    }

    @Test
    public void testSortWordsInAllSentencesShouldReturnSortedText() {
        TextProcessor processor = new TextProcessor();
        Component actualComponent = processor.sortParagraphsBySentenceLength(UNSORTED_TEXT_FOR_SORTING);
        Assert.assertEquals(SORTED_TEXT_FOR_SORTING, actualComponent);
    }
}
