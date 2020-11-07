package com.epam.information.handling.data;

import com.epam.information.handling.exception.DataException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileDataReader {

    public String read(String filename) throws DataException {
        Path path = Paths.get(filename);
        String text;
        try {
            List<String> lines = Files.readAllLines(path);
            String lineSeparator = System.lineSeparator();
            text = String.join(lineSeparator, lines);
        } catch (IOException e) {
            throw new DataException("File not found.");
        }
        return text;
    }
}
