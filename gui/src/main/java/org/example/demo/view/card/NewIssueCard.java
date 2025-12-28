package org.example.demo.view.card;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class NewIssueCard extends Card {

    @FXML
    private AnchorPane root;

    NewIssueCard() {
        super("card-create-issue.fxml");
    }

    @Override
    public Parent getRoot() {
        return root;
    }
}
