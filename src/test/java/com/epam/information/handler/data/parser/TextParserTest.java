package com.epam.information.handler.data.parser;

import com.epam.information.handling.data.component.Component;
import com.epam.information.handling.data.component.Composite;
import com.epam.information.handling.data.component.Leaf;
import com.epam.information.handling.data.parser.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class TextParserTest {
    private static final String VALID_TEXT = "Hello world! From tests!\nHello world! From tests!";
    private static final Component LEAF = Leaf.createWord("Hello world! From test!");
    private static final Component EXPECTED_COMPONENT = new Composite();

    @Before
    public void buildExpectedComponent() {
        EXPECTED_COMPONENT.add(LEAF);
        EXPECTED_COMPONENT.add(LEAF);
    }

    @Test
    public void testParseShouldReturnCorrectComponentWhenTextValid() {
        TextParser textParser = new TextParser();
        Parser paragraph = Mockito.mock(ParagraphParser.class);
        textParser.setSuccessor(paragraph);
        when(paragraph.parse(anyString())).thenReturn(LEAF);
        Component actualComponent = textParser.parse(VALID_TEXT);
        Assert.assertEquals(EXPECTED_COMPONENT, actualComponent);
    }
}