package org.example.demo.view.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.example.demo.view.components.modal.Modal;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Component extends Window {
    protected List<Component> list = new ArrayList<>();
    protected Parent root;

    public void addComponent(Component component) {
        list.add(component);
    }

    public void show(String file) {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(file));
        loader.setController(this);
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void asModal(Parent parent) {
        Modal.show(root, parent);
    }

    public Parent getRoot() {
        return root;
    }
}
