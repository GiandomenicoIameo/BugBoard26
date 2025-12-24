package org.example.demo.view.home;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import org.example.demo.view.Component;
import org.example.demo.view.card.CardIssue;
import java.io.IOException;

class Regular extends Homepage {

    @FXML
    private VBox cardContainer;

    Regular() {

        FXMLLoader loader;
        loader = new FXMLLoader(getClass().
                getResource("regular-homepage.fxml"));

        loader.setController(this);

        try {
            this.view = loader.load();
        } catch (IOException e) {
            throw new RuntimeException("Impossibile " +
                    "caricare la vista", e);
        }
    }

    protected void viewComponents() {
        //cardContainer.getChildren().clear();

        for(Component component : components) {
            if(component instanceof CardIssue)
                cardContainer.getChildren().
                        add(((CardIssue)component).getRoot());
        }
    }
}
