package com.epam.information.handling.logic;

import com.epam.information.handling.data.component.Component;
import com.epam.information.handling.data.component.Composite;
import com.epam.information.handling.data.component.Leaf;
import com.epam.information.handling.data.component.LeafType;

import java.util.List;

public class TextProcessor {

    public Component resolveMathExpressions(Component component) {
        List<Component> components = component.getComponents();
        if (components.isEmpty()) {
            Leaf leaf = (Leaf) component;
            return manipulateLeaf(leaf);
        }
        Component resolved = new Composite();
        for (Component child : components) {
            Component childResolved = resolveMathExpressions(child);
            resolved.add(childResolved);
        }
        return resolved;
    }

    private Leaf manipulateLeaf(Leaf leaf) {
        LeafType leafType = leaf.getLeafType();
        if (leafType != LeafType.EXPRESSION) {
            return leaf;
        }
        String value = prepareStringToCalculate(leaf);
        Calculator calculator = new Calculator();
        int result = calculator.calculate(value);
        String stringResult = Integer.toString(result);
        return Leaf.createWord("[" + stringResult + "]");
    }

    private String prepareStringToCalculate(Leaf leaf) {
        String value = leaf.getValue();
        int length = value.length();
        return value.substring(1, length - 1);
    }
}
