package com.epam.information.handler.data.parser;

import com.epam.information.handling.data.component.Component;
import com.epam.information.handling.data.component.Composite;
import com.epam.information.handling.data.component.Leaf;
import com.epam.information.handling.data.parser.ParagraphParser;
import com.epam.information.handling.data.parser.Parser;
import com.epam.information.handling.data.parser.SentenceParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class ParagraphParserTest {
    private static final String VALID_TEXT = "Hello world! Hello world!";
    private static final Component LEAF = Leaf.createWord("Hello world!");
    private static final Component EXPECTED_COMPONENT = new Composite();

    @Before
    public void buildExpectedComponent() {
        EXPECTED_COMPONENT.add(LEAF);
        EXPECTED_COMPONENT.add(LEAF);
    }

    @Test
    public void testParseShouldReturnCorrectComponentList() {
        ParagraphParser parser = new ParagraphParser();
        Parser sentence = Mockito.mock(SentenceParser.class);
        parser.setSuccessor(sentence);
        when(sentence.parse(anyString())).thenReturn(LEAF);
        Component actualComponent = parser.parse(VALID_TEXT);
        Assert.assertEquals(EXPECTED_COMPONENT, actualComponent);
    }

}
