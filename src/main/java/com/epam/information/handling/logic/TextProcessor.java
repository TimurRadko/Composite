package com.epam.information.handling.logic;

import com.epam.information.handling.data.component.Component;
import com.epam.information.handling.data.component.Composite;
import com.epam.information.handling.data.component.Leaf;
import com.epam.information.handling.data.component.LeafType;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TextProcessor {
    private static final String PARAGRAPH_SEPARATOR = System.lineSeparator();

    public Component calculateMathExpression(Component component) {
        List<Component> children = component.getChildren();
        if (children.isEmpty()) {
            Leaf leaf = (Leaf) component;
            return manipulateLeaf(leaf);
        }

        List<Component> resolvedComponents = new ArrayList<>();
        for (Component child : children) {
            Component childResolved = calculateMathExpression(child);
            resolvedComponents.add(childResolved);
        }
        return new Composite(resolvedComponents);
    }

    private Leaf manipulateLeaf(Leaf leaf) {
        LeafType leafType = leaf.getLeafType();
        if (leafType != LeafType.EXPRESSION) {
            return leaf;
        }
        String value = leaf.getValue();
        Calculator calculator = new Calculator();
        int result = calculator.calculate(value);
        String stringResult = Integer.toString(result);
        return Leaf.createWord("[" + stringResult + "] ");
    }

    public String restoreText(Component root) {
        StringBuilder text = new StringBuilder();
        for (Component paragraph : root.getChildren()) {
            for (Component sentence : paragraph.getChildren()) {
                for (Component lexeme : sentence.getChildren()) {
                    String lexemeValue = ((Leaf) lexeme).getValue();
                    text.append(lexemeValue);
                }
            }
            text.append(PARAGRAPH_SEPARATOR);
        }
        return prepareText(text);
    }

    private String prepareText(StringBuilder builder) {
        String rawText = builder.toString();
        int length = rawText.length();
        return rawText.substring(0, length - 2);
    }

    public Component sortParagraphsBySentenceLength(Component text) {
        List<Component> paragraphs = text.getChildren();
        paragraphs.sort(Comparator.comparingInt(paragraph -> {
            List<Component> children = paragraph.getChildren();
            return children.size();
        }));
        return new Composite(paragraphs);
    }

    public Component sortWordsInAllSentences(Component text) {
        List<Component> paragraphs = text.getChildren();
        for (Component paragraph : paragraphs) {
            List<Component> sentences = paragraph.getChildren();
            for (Component sentence : sentences) {
                List<Component> lexemes = sentence.getChildren();
                sort(lexemes);
            }
        }
        return new Composite(paragraphs);
    }

    private void sort(List<Component> lexemes) {
        lexemes.sort(Comparator.comparingInt(lexeme -> {
            String lexemeValue = ((Leaf) lexeme).getValue();
            return lexemeValue.length();
        }));
    }
}