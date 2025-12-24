package org.example.demo.view.home;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import org.example.demo.view.card.CardIssue;

import java.io.IOException;

class Administrator extends Homepage {

    @FXML
    private VBox cardContainer;

    Administrator() {

        FXMLLoader loader;
        loader = new FXMLLoader(getClass().
                getResource("admin-homepage.fxml"));

        loader.setController(this);

        try {
            this.view = loader.load();
        } catch (IOException e) {
            throw new RuntimeException("Impossibile " +
                    "caricare la vista", e);
        }
    }

//    protected void viewCards() {
//        //cardContainer.getChildren().clear();
//
//        for(CardIssue card : cards) {
//            cardContainer.getChildren().add(card.getRoot());
//        }
//    }
}
