package com.epam.information.handling.data.reader;

import com.epam.information.handling.data.reader.DataReader;
import com.epam.information.handling.exception.DataException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileDataReader implements DataReader {

    @Override
    public String read(String filename) throws DataException {
        Path path = Paths.get(filename);
        StringBuilder resultBuilder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            lines.forEach(line -> resultBuilder.append(line).append('\n'));
        } catch (IOException e) {
            throw new DataException("Exception. Cause: ", e);
        }
        return resultBuilder.toString();
    }
}
