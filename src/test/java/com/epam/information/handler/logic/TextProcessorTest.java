package com.epam.information.handler.logic;

import com.epam.information.handling.data.component.Component;
import com.epam.information.handling.logic.TextProcessor;
import org.junit.Assert;
import org.junit.Test;

public class TextProcessorTest {

    @Test
    public void testRestoreTextShouldReturnRestoredTextWhenComponentIsText() {
        TextProcessor processor = new TextProcessor();
        Component actualComponent = TextProcessorHelper.getUnsortedTextForWordsSorting();
        String actualString = processor.restoreText(actualComponent);
        String expectedString = TextProcessorHelper.getExpectedText();
        Assert.assertEquals(expectedString, actualString);
    }

    @Test
    public void testSortParagraphsBySentenceLengthShouldReturnSortedText() {
        TextProcessor processor = new TextProcessor();
        Component actualComponent = TextProcessorHelper.getUnsortedTextForParagraphSorting();
        Component actualSortedComponent =
                processor.sortParagraphsBySentenceLength(actualComponent);
        Component expectedSortedText = TextProcessorHelper.getSortedTextForParagraphSorting();
        Assert.assertEquals(expectedSortedText, actualSortedComponent);
    }

    @Test
    public void testSortWordsInAllSentencesShouldReturnSortedText() {
        TextProcessor processor = new TextProcessor();
        Component actualComponent = TextProcessorHelper.getUnsortedTextForWordsSorting();
        Component actualSortedComponent =
                processor.sortWordsInAllSentences(actualComponent);
        Component expectedSortedText = TextProcessorHelper.getSortedTextForWordsSorting();
        Assert.assertEquals(expectedSortedText, actualSortedComponent);
    }
}
