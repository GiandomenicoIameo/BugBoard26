package org.example.demo.view.home;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.demo.view.Sequence;

/*
    Il seguente metodo viene utilizzato per visualizzare
    la schermata homepage relativa agli Amministratori,
    utenti normali e agli Stakeholder.
 */

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        Homepage homepage = new Regular();

        Sequence.setStage(stage);
        Sequence.setScene(homepage.show());
    }

    public static void main() {
        launch();
    }
}