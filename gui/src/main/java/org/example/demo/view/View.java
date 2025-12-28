package org.example.demo.view;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;

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

    protected void componentsView() {
        System.out.println(components);
    }

    protected Parent showView() {
        return view;
    }

    protected void shiftView(ActionEvent event, View view) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().
                getWindow();
        Tab.setScene(view.showView(),stage);
    }
}
