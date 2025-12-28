package org.example.demo.view.card;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import java.util.Objects;

public class IssueCard extends Card {

    @FXML
    private Button favourite;
    private boolean isFavourite = false;

    @FXML
    private VBox root;

    IssueCard() {
        super("card-issue.fxml");
    }

    @Override
    public Parent getRoot() {
        return root;
    }

    @FXML
    protected void cambiaIcona(ActionEvent e) {

        String imagePath;

        if( !isFavourite ) {
            imagePath = "/org/example/demo/view/icons/favourite-red.png";
            isFavourite = true;
        } else {
            imagePath = "/org/example/demo/view/icons/favourite.png";
            isFavourite = false;
        }

        try {
            Image image = new Image((Objects.requireNonNull(getClass().
                    getResourceAsStream(imagePath))));
            ImageView imageView = new ImageView(image);

            imageView.setFitHeight(30);
            imageView.setFitWidth(30);

            favourite.setGraphic(imageView);
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
    }
}