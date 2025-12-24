package org.example.demo.view.home;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/*
    Il seguente metodo viene utilizzato per visualizzare
    la schermata homepage relativa agli Amministratori,
    utenti normali e agli Stakeholder.
 */

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        Homepage root = new Regular();
        Scene scene = new Scene(root.show());

        stage.setTitle("BugBoard26");
        stage.setScene(scene);
        stage.show();
    }

    public static void main() {
        launch();
    }
}