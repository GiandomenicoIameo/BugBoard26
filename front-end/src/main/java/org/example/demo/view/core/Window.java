package org.example.demo.view.core;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.transform.Scale;
import javafx.stage.Screen;
import javafx.util.Duration;
import org.example.demo.view.core.orchestration.Orchestration;
import org.example.demo.view.orchestrator.Orchestrator;

public abstract class Window {
    protected static Orchestration orchestration =
            new Orchestrator();

    @FXML
    protected void close() {
        System.exit(0);
    }

    @FXML
    protected void minimize() {
        Sequence.getCurrStage()
                .setIconified(true);
    }

    protected Scene resize(Parent root) {
        double SCREEN_W_RATIO = 0.90;
        double SCREEN_H_RATIO = 0.85;
        double MAX_SCALE = 1.0;

        double width = root.prefWidth(-1);
        double high =  root.prefHeight(width);

        Rectangle2D screen = Screen.getPrimary()
                .getVisualBounds();

        double scale = Math.min(
                screen.getHeight() *
                        SCREEN_H_RATIO / high,
                screen.getWidth()  *
                        SCREEN_W_RATIO / width);
        scale = Math.min(
                scale, MAX_SCALE);

        root.getTransforms()
                .setAll(new Scale(scale,
                scale, 0, 0));

        return new Scene(
                new Group(root),
                width * scale, high * scale);
    }

    protected void fade(Parent root) {
        FadeTransition fade =
                new FadeTransition(Duration
                        .millis(800), root);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
    }
}
