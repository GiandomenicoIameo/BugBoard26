package org.example.demo.view;

import javafx.scene.Parent;
import java.util.ArrayList;
import java.util.List;

public abstract class Component {

    protected List<Component> list = new ArrayList<>();

    public Parent getRoot() {
        return null;
    }

    public Component getInstance() {
        return this;
    }
}
