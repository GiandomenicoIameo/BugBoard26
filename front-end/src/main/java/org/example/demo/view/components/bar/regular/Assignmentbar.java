package org.example.demo.view.components.bar.regular;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import org.example.demo.view.components.card.issue.IssueContentCard;
import org.example.demo.view.components.card.issue.IssueItemCard;
import org.example.demo.view.components.card.issue.definitions.issueItemCard.IssueItemCardView;
import org.example.demo.view.core.Component;
import org.example.demo.view.core.Sequence;
import java.io.IOException;
import java.util.List;

public class Assignmentbar extends Component {
    @FXML private AnchorPane assignmentsbar;
    @FXML private TextField search;
    @FXML private VBox cardContainer;
    @FXML private VBox boxContainer;
    @FXML private HBox searchbar;
    @FXML private VBox emailBox;

    @FXML private Label numIssue;
    @FXML private Label id;

    private int issues;

    public Assignmentbar() {
        show("assignmentsbar.fxml");
    }

    @Override
    public Parent getRoot() {
        return assignmentsbar;
    }

    public void importContentCard(IssueContentCard card) {
        boxContainer.getChildren()
                .clear();
        boxContainer.getChildren()
                .add(card
                        .getRoot());
    }

    public void importCard() throws IOException,
            InterruptedException {
        List<IssueItemCard> list =
                orchestration.issueItem()
                        .getAllAssigned(IssueItemCard::new,
                        IssueContentCard::new);

        for (IssueItemCardView card : list) {
            card.setCallback(box -> {
                importContentCard((IssueContentCard) box);
                id.setText(card
                        .getId());
            });

            cardContainer.getChildren().
                    add(card.getRoot());
        }
        countIssues(list.size());
    }

    private void countIssues(Integer size) {
        numIssue.setText(size
                .toString());
    }

    @FXML
    public void searchBug() {
        int count = 0;

        String target = search.getText()
                .toLowerCase();
        boolean match = true;

        for (Node nodo : cardContainer.getChildren()) {
            if (nodo instanceof Button pulsante) {
                Label username = (Label)
                        pulsante.lookup("#name");

                if(!target.isEmpty()) {
                    match = username.getText()
                            .toLowerCase()
                            .equals(target);
                    if(!match)
                        count++;
                }

                pulsante.setVisible(match);
                pulsante.setManaged(match);
            }
        }
        int res = issues - count;
        countIssues(res);
    }

    public void viewSearchbar() {
        if (!searchbar.isVisible()) {
            searchbar.setVisible(true);
            searchbar.setManaged(true);

            double altezzaFissa = searchbar.getPrefHeight();
            if (altezzaFissa <= 0) altezzaFissa = 60; // Fallback di sicurezza

            TranslateTransition scendi = new TranslateTransition(Duration.seconds(0.3), searchbar);
            scendi.setFromY(-altezzaFissa); // Parte esplicitamente da sopra
            scendi.setToY(0);               // Arriva alla posizione normale
            scendi.play();

        } else {
            double altezzaFissa = searchbar.getPrefHeight();
            if (altezzaFissa <= 0) altezzaFissa = 60;

            TranslateTransition sali = new TranslateTransition(Duration.seconds(0.3), searchbar);
            sali.setFromY(0);               // Parte dalla posizione normale
            sali.setToY(-altezzaFissa);     // Risale fuori dallo schermo

            sali.setOnFinished(event -> {
                searchbar.setVisible(false);
                searchbar.setManaged(false);
                searchbar.setTranslateY(0); // Resetta lo stato per il prossimo giro
            });

            sali.play();
        }
    }

    private TranslateTransition translate(int src, int dst) {
        TranslateTransition move = new TranslateTransition(
                Duration.seconds(0.3), searchbar);
        move.setFromY(src);
        move.setToY(dst);

        return move;
    }

    @FXML
    public void initialize() throws IOException,
            InterruptedException {
        // Serve per far comparire l'HBox
        // sotto l'achorPane quando
        // si vuole cercare una card.
        searchbar.setViewOrder(1.0);

        configureMaximize(assignmentsbar, Sequence
                .getCurrStage());
        importCard();
        issues = Integer.parseInt(numIssue
                .getText());
    }

    @FXML
    public void refresh() throws IOException,
            InterruptedException {
        emailBox.setOpacity(0.0);
        cardContainer.getChildren()
                .clear();
        fade(emailBox);
        importCard();
    }
}
