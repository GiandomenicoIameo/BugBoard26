package org.example.demo.view;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Sequence {
    private static Scene scene;
    private static Stage stage;

    public static void setScene(Parent parent) {
        scene = new Scene(parent);
        show();
    }

    public static void setStage(Stage currStage) {
        stage = currStage;
    }

    public static Scene getScene() {
        return scene;
    }

    private static void show() {
        stage.setScene(scene);
        stage.show();
    }
}
