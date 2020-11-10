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
    private static final String EXPRESSION_SEPARATOR = " ";

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
        return Leaf.createWord(stringResult + EXPRESSION_SEPARATOR);
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
        return text.toString().trim();
    }

    public Component sortParagraphsBySentenceLength(Component text) {
        List<Component> sortedParagraphs = new ArrayList<>(text.getChildren());
        Comparator<Component> comparator =
                Comparator.comparingInt(sortedParagraph -> sortedParagraph.getChildren().size());
        sortedParagraphs.sort(comparator);
        return new Composite(sortedParagraphs);
    }

    public Component sortWordsInAllSentences(Component text) {
        List<Component> paragraphs = new ArrayList<>();
        for (Component paragraph : text.getChildren()) {
            List<Component> sentences = new ArrayList<>();
            for (Component sentence : paragraph.getChildren()) {
                List<Component> sortedLexemes = new ArrayList<>(sentence.getChildren());
                sortLexemes(sortedLexemes);
                sentences.add(new Composite(sortedLexemes));
            }
            paragraphs.add(new Composite(sentences));
        }
        return new Composite(paragraphs);
    }

    private void sortLexemes(List<Component> sortedLexemes) {
        sortedLexemes.sort(Comparator.comparingInt(lexeme -> {
            String lexemeValue = ((Leaf) lexeme).getValue();
            return lexemeValue.length();
        }));
    }
}