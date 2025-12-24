package org.example.demo.view;

import javafx.scene.Node;

import java.util.HashMap;
import java.util.Map;

public abstract class View {
    protected Map<Component, Node> components = new HashMap<>();

    protected void addComponent(Component component) {
        components.put(component,component.getRoot());
    }

    protected void viewComponents() {
        System.out.println(components);
    }
}
