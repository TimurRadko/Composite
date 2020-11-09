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

    public String restoreText(Component component) {
        List<Component> children = component.getChildren();
        StringBuilder builder = new StringBuilder();
        if (children.size() > 0) {
            for (Component child : children) {
                builder.append(restoreParagraph(child)).append(PARAGRAPH_SEPARATOR);
            }
        } else {
            restoreParagraph(component);
        }
        return prepareText(builder);
    }

    private String prepareText(StringBuilder builder) {
        String rawText = builder.toString();
        int length = rawText.length();
        return rawText.substring(0, length - 2);
    }

    private String restoreParagraph(Component component) {
        List<Component> children = component.getChildren();
        StringBuilder builder = new StringBuilder();
        if (children.size() > 0) {
            for (Component child : children) {
                builder.append(restoreSentence(child));
            }
        } else {
            restoreSentence(component);
        }
        return builder.toString();
    }

    private String restoreSentence(Component component) {
        List<Component> children = component.getChildren();
        StringBuilder builder = new StringBuilder();
        for (Component child : children) {
            Leaf leaf = (Leaf) child;
            String leafValue = leaf.getValue();
            builder.append(leafValue);
        }
        return builder.toString();
    }

    public Component sortParagraphsBySentenceLength(Component text) {
        List<Component> paragraphs = text.getChildren();
        paragraphs.sort(Comparator.comparingInt(paragraph -> paragraph.getChildren().size()));
        return new Composite(paragraphs);
    }

    public Component sortWordsInAllSentences(Component text) {
        List<Component> paragraphs = text.getChildren();
        for (Component paragraph : paragraphs) {
            List<Component> sentences = paragraph.getChildren();
            for (Component sentence : sentences) {
                List<Component> lexemes = sentence.getChildren();
                lexemes.sort(Comparator.comparingInt(lexeme -> {
                    String lexemeValue = ((Leaf) lexeme).getValue();
                    return lexemeValue.length();
                }));
            }
        }
        return new Composite(paragraphs);
    }
}