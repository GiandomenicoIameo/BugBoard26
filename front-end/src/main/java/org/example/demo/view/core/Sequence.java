package org.example.demo.view.core;

import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.example.demo.view.access.Login;

public class Sequence {
    private static Stage current  = null;

    public static void setCurrStage(Stage stage) {
        if(current == null) {
            current = stage;
            current.initStyle(StageStyle
                    .TRANSPARENT);
        }
    }

    public static Stage getCurrStage() {
        return current;
    }

    public static void viewScene(Scene scene) {
        // Imposta la nuova scena (ovvero la nuova schermata
        // che deve essere mostrata).
        current.setScene(scene);
        current.sizeToScene();
        current.centerOnScreen();
        // Ricalcola il centro in base alla
        // nuova dimensione della finestra
        scene.setFill(Color
                .TRANSPARENT);
        current.show();
    }
}
