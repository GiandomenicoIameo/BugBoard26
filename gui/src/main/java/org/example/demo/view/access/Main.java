package org.example.demo.view.access;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.demo.view.Tab;

/* La seguente classe è stata creata con il solo
   scopo di testare le varie interfacce di accesso.
 */

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Access access = new Login();
        Tab.setScene(access.showView(), stage);
    }

    public static void main() {
        launch();
    }
}
