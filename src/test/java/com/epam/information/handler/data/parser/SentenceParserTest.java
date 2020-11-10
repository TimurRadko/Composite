package com.epam.information.handler.data.parser;

import com.epam.information.handling.data.component.Component;
import com.epam.information.handling.data.component.Leaf;
import com.epam.information.handling.data.parser.SentenceParser;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SentenceParserTest {
    private static final String VALID_TEXT = "The maths is 5_3_+ good.";
    private static final Component EXPECTED_LEAF = Leaf.createWord("The ");

    @Test
    public void testParseShouldCorrectParseWhenSentenceIsValid() {
        SentenceParser parser = new SentenceParser(null);
        Component actualComponent = parser.parse(VALID_TEXT);
        List<Component> components = actualComponent.getChildren();
        Component component = components.get(0);
        Assert.assertEquals(EXPECTED_LEAF, component);
    }
}
