package com.epam.information.handler.data;

import com.epam.information.handling.data.FileDataReader;
import com.epam.information.handling.exception.DataException;
import org.junit.Assert;
import org.junit.Test;

public class FileDataReaderTest {
    private static final String VALID_FILE_PATH = "src/test/resources/test-text.txt";
    private static final String INVALID_FILE_PATH = "src/test/resources/invalid.txt";
    private static final String EXPECTED_TEXT = "Hello world!\nFrom tests!\n";

    @Test
    public void testReadShouldCorrectReadTextFromFileWhenFileExists() throws DataException {
        FileDataReader fileDataReader = new FileDataReader();
        String actualText = fileDataReader.read(VALID_FILE_PATH);
        Assert.assertEquals(EXPECTED_TEXT, actualText);
    }

    @Test(expected = DataException.class)
    public void testReadShouldThrowDataExceptionWhenFileNotExists() throws DataException {
        FileDataReader fileDataReader = new FileDataReader();
        fileDataReader.read(INVALID_FILE_PATH);
    }
}
