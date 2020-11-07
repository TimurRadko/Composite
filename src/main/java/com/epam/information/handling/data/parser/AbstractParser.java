package com.epam.information.handling.data.parser;

public abstract class AbstractParser implements Parser {
    private Parser successor;

    protected Parser getSuccessor() {
        return successor;
    }

    public void setSuccessor(Parser successor) {
        this.successor = successor;
    }
}
