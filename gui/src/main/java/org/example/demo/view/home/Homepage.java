package org.example.demo.view.home;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import org.example.demo.view.View;
import java.util.Collection;


public abstract class Homepage extends View {

    protected Parent view;

    @FXML
    private VBox cardContainer;

    public static Homepage createRegular() {
        return new Regular();
    }

    public static Homepage createAdministrator() {
        return new Administrator();
    }

    @FXML
    protected void signOut(ActionEvent e) {
        System.exit(0);
    }

    public Parent show() {
        return view;
    }

    @Override
    protected void viewComponents() {
        Collection<Node> nodes = components.values();

        //cardContainer.getChildren().clear();
        cardContainer.getChildren().addAll(nodes);
    }
}