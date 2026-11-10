package org.example.demo.view.session;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import org.example.demo.view.components.bar.Feedbar;
import org.example.demo.view.components.bar.Settingsbar;
import org.example.demo.view.components.bar.Sidebar;
import org.example.demo.view.core.Component;
import org.example.demo.view.core.View;
import org.example.demo.view.listeners.SidebarListener;

public abstract class Dock extends View
        implements SidebarListener {

    @FXML protected StackPane dockContainer;
    @FXML protected StackPane sidebarContainer;

    public Dock() {
        addComponent(new Feedbar());
        setListeners();
    }

    protected void setListeners() {
        // La seguente istruzione ritarda l'esecuzione di setListeners()
        // Infatti, il corpo di setListeners() viene eseguito
        // alla fine del corpo del costruttore figlio (Regular o
        // Administrator).
        Platform.runLater(() ->
                getComponent(Sidebar.class)
                        .setListener(this)
        );
    }

    protected void toDock(Component component,
                          Pane container)  {
        container.getChildren()
                .add(component.getRoot());
    }

    @Override
    public void viewFeed() {
        current(getComponent(
                Feedbar.class));
    }

    @Override
    public void viewSettings() {
        current(getComponent(
                Settingsbar.class));
    }

    @Override
    public void signOut() {
        orchestration.login()
                .logout();
    }

    @FXML
    public void initialize() {
        current = getComponent(
                Feedbar.class);
    }
}