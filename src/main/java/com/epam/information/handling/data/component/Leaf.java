package com.epam.information.handling.data.component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Leaf implements Component {
    private final LeafType leafType;
    private final String value;

    private Leaf(LeafType leafType, String value) {
        this.leafType = leafType;
        this.value = value;
    }

    public static Leaf createWord(String value)  {
        return new Leaf(LeafType.WORD, value);
    }

    public static Leaf createExpression(String value) {
        return new Leaf(LeafType.EXPRESSION, value);
    }

    public String getValue() {
        return value;
    }

    public LeafType getLeafType() {
        return leafType;
    }

    @Override
    public List<Component> getChildren() {
        return new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Leaf leaf = (Leaf) o;

        if (leafType != leaf.leafType) {
            return false;
        }
        return Objects.equals(value, leaf.value);
    }

    @Override
    public int hashCode() {
        int result = leafType != null ? leafType.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Leaf{" +
                "leafType=" + leafType +
                ", value='" + value + '\'' +
                '}';
    }
}
