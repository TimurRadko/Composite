package com.epam.information.handling.data.component;

import java.util.List;

public interface Component {
    void add(Component component);
    List<Component> getComponents();
}
