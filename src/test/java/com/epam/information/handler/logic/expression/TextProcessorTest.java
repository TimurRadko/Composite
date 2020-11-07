package com.epam.information.handler.logic.expression;

import com.epam.information.handling.data.component.Component;
import com.epam.information.handling.data.component.Leaf;
import com.epam.information.handling.logic.TextProcessor;
import org.junit.Assert;
import org.junit.Test;

public class TextProcessorTest {
    private static final Component LEAF = Leaf.createExpression("[5 3 +]");
    private static final Component EXPECTED_LEAF = Leaf.createWord("[8]");

    @Test
    public void testResolveMathExpressionsShouldReturnCorrectAnswer() {
        TextProcessor processor = new TextProcessor();
        Component actualLeaf = processor.resolveMathExpressions(LEAF);
        Assert.assertEquals(EXPECTED_LEAF, actualLeaf);
    }
}
