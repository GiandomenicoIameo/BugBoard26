package org.example.demo.view;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Tab {
    private static Scene scene;

    public static void setScene(Parent tab, Stage stage) {
        scene = new Scene(tab);

        stage.setScene(scene);
        stage.show();
    }

    public static Scene getScene() {
        return scene;
    }
}
