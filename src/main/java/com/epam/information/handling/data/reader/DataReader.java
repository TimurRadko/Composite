package com.epam.information.handling.data.reader;

import com.epam.information.handling.exception.DataException;

public interface DataReader {
    String read(String filename) throws DataException;
}
