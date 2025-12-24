package org.example.demo.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.demo.view.card.CardIssue;
import org.example.demo.view.home.Homepage;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        View view = Homepage.createAdministrator();
        Scene scene = new Scene(((Homepage) view).show());

        CardIssue card1 = new CardIssue();
        CardIssue card2 = new CardIssue();
        CardIssue card3 = new CardIssue();

        view.addComponent(card1);
        view.addComponent(card2);
        view.addComponent(card3);

        view.viewComponents();

        stage.setTitle("BugBoard26");
        stage.setScene(scene);
        stage.show();
    }

    public static void main() {
        launch();
    }
}