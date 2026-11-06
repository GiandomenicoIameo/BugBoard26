package org.example.demo.view.core;

import javafx.animation.FadeTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.util.Duration;
import org.example.demo.view.core.orchestration.Orchestration;
import org.example.demo.view.orchestrator.Orchestrator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class View extends Window {
    protected Map<Component, Node> components =
            new HashMap<>();
    // Questa variabile di istanza viene utilizzata per memorizzare
    // l'interfaccia.
    protected Parent view;
    protected Component current;

    public void addComponent(Component component) {
        components.put(component,component.getRoot());
    }

    public Component move(Component next) {
        current.getRoot()
                .setVisible(false);
        next.getRoot()
                .setOpacity(0.0);
        next.getRoot()
                .setVisible(true);
        fade(next);

        return next;
    }

    private void fade(Component next) {
        FadeTransition fadeIn =
                new FadeTransition(Duration
                .millis(400), next.getRoot());
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }

    public void current(Component next) {
        if(current == null)
            current = next;
        else
            current = move(next);
    }

    public void show(String file) {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(file));
        loader.setController(this);
        try {
            view = loader.load();
            // In questo caso, l'oggetto view viene impostato
            // sulla Scene della finestra principale (Stage)
            // dal metodo viewScene. Ecco perché la schermata viene
            // visualizzata immediatamente quando viene invocato
            // tale metodo. Cosa che non succede quando viene
            // invocato il metodo Component.show().
            Sequence.viewScene(
                    resize(view));
            fade(view);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
