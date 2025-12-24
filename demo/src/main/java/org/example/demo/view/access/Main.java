package org.example.demo.view.access;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

/* La seguente classe è stata creata con il solo
   scopo di testare le varie interfacce di accesso.
 */

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        Access access = new Login();
        Scene scene = new Scene(access.view());

        stage.setTitle("BugBoard26");
        stage.setScene(scene);
        stage.show();
    }

    public static void main() {
        launch();
    }
}
