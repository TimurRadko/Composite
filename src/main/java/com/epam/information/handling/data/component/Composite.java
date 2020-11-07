package com.epam.information.handling.data.component;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private final List<Component> components = new ArrayList<>();

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public List<Component> getComponents() {
        return components;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Composite composite = (Composite) o;

        return components.equals(composite.components);
    }

    @Override
    public int hashCode() {
        return components.hashCode();
    }

    @Override
    public String toString() {
        return prepareToString();
    }

    private String prepareToString() {
        StringBuilder builder = new StringBuilder();
        for (Component component : components) {
            builder.append(component).append(" ");
        }
        return builder.toString();
    }
}
