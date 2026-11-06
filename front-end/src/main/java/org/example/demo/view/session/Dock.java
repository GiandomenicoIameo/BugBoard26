package org.example.demo.view.session;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import org.example.demo.view.components.bar.Feedbar;
import org.example.demo.view.components.bar.Settingsbar;
import org.example.demo.view.components.bar.Sidebar;
import org.example.demo.view.core.Component;
import org.example.demo.view.core.View;
import org.example.demo.view.listeners.SidebarListener;

public abstract class Dock<T extends Sidebar> extends View implements SidebarListener {
    protected T sidebar;
    protected Settingsbar settingsbar;
    protected Feedbar feedbar;

    @FXML protected StackPane dockContainer;
    @FXML protected StackPane sidebarContainer;

    public Dock() {
        feedbar = new Feedbar();
    }

    protected void config() {
        // Le istruzioni addComponent() sono opzionali, in quanto vengono
        // utilizzate solo per mantenere la relazione di composizione.

        current = feedbar;
    }

    protected abstract void setListeners();

    @FXML
    public void initialize() {
        config();
        setListeners();
    }

    protected void add(Component component,
                     Pane container)  {
        container.getChildren()
                .add(component.getRoot());
    }

    @Override
    public void viewFeed() {
        current(feedbar);
    }

    @Override
    public void viewSettings() {
        current(settingsbar);
    }
}