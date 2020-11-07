package com.epam.information.handler.data;

import com.epam.information.handling.data.parser.ChainBuilder;
import com.epam.information.handling.data.parser.Parser;
import org.junit.Assert;
import org.junit.Test;

public class ChainBuilderTest {

    @Test
    public void testBuildShouldBuildChain() {
        ChainBuilder builder = new ChainBuilder();
        Parser parser = builder.build();
        Assert.assertNotNull(parser);
    }
}
