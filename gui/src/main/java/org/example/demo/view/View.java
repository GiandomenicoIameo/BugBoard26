package org.example.demo.view;

import java.util.ArrayList;
import java.util.List;

public abstract class View {
    protected List<Component> components = new ArrayList<>();

    protected void addComponent(Component component) {
        components.add(component);
    }

    protected void viewComponents() {
        for(Component component : components)
            System.out.println(component);
    }
}
