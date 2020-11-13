package com.epam.information.handling.data.parser;

import com.epam.information.handling.data.component.Component;

public interface Parser {
    Component parse(String text);
}
