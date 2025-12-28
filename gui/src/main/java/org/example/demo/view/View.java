package org.example.demo.view;

import javafx.scene.Node;
import javafx.scene.Parent;
import java.util.HashMap;
import java.util.Map;

public abstract class View {
    protected Map<Component, Node> components = new HashMap<>();
    // Questa variabile di istanza viene utilizzata per memorizzare
    // l'interfaccia.
    protected Parent view;

    protected void addComponent(Component component) {
        components.put(component,component.getRoot());
    }

    protected void listComponents() {
        System.out.println(components);
    }

    protected Parent show() {
        return view;
    }

    protected void skip(View view) {
        Sequence.setScene(view.show());
    }
}
