package org.example.demo.view;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.demo.view.card.Card;
import org.example.demo.view.home.Homepage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        View view = Homepage.createAdministrator();

        //Creazione della card che consente la creazione
        //di una Issue.
        Component card1 = Card.createNewIssueCard();

        Component card2 = Card.createIssueCard();
        Component card3 = Card.createIssueCard();
        Component card4 = Card.createIssueCard();

        //Aggiunta delle card alla schermata Homepage.
        view.addComponent(card1);
        view.addComponent(card2);
        view.addComponent(card3);
        view.addComponent(card4);

        //Visualizzazione dei componenti della homepage.
        view.listComponents();

        Sequence.setStage(stage);
        Sequence.setScene(view.show());
    }

    public static void main() {
        launch();
    }
}