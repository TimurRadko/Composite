package com.epam.information.handler.data.parser;

import com.epam.information.handling.data.component.Component;
import com.epam.information.handling.data.component.Composite;
import com.epam.information.handling.data.component.Leaf;
import com.epam.information.handling.data.parser.*;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.mockito.Mockito.*;

public class TextParserTest {
    private static final String VALID_TEXT = "Hello world! From tests!\nHello world! From tests!";
    private static final Component PARAGRAPH = Leaf.createWord("Hello world! From tests!");
    private static final Component EXPECTED_COMPONENT = new Composite(Arrays.asList(PARAGRAPH, PARAGRAPH));

    @Test
    public void testParseShouldReturnCorrectComponentWhenTextValid() {
        Parser paragraph = Mockito.mock(ParagraphParser.class);
        TextParser textParser = new TextParser(paragraph);
        when(textParser.parse(VALID_TEXT)).
                thenAnswer(invocation -> Leaf.createWord(((String) invocation.getArguments()[0])));
        Component actualComponent = textParser.parse(VALID_TEXT);
        Assert.assertEquals(EXPECTED_COMPONENT, actualComponent);
    }
}