package org.example.demo.view.components.bar.regular;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.example.demo.view.components.card.issue.IssueContentCard;
import org.example.demo.view.components.card.issue.IssueItemCard;
import org.example.demo.view.components.card.issue.definitions.issueItemCard.IssueItemCardView;
import org.example.demo.view.core.Component;
import org.example.demo.view.core.Sequence;
import org.example.demo.view.shared.Searchbar;

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

    private void clearContainer(VBox container) {
        container.getChildren()
                .clear();
    }

    private void countIssues(Integer size) {
        numIssue.setText(size
                .toString());
    }

    private void addItemCard(IssueItemCardView card) {
        cardContainer.getChildren()
                .add(card.getRoot());
    }

    private void renderItemCards(List<IssueItemCardView> cards) {
        clearContainer(cardContainer);
        for (IssueItemCardView card : cards) {
            onAction(card);
            addItemCard(card);
        } countIssues(cards.size());
    }

    public void showContentCard(IssueContentCard card) {
        clearContainer(boxContainer);
        boxContainer.getChildren()
                .add(card.getRoot());
    }

    private void onAction(IssueItemCardView card) {
        card.setCallback(box -> {
            showContentCard((IssueContentCard) box);
            id.setText(card
                    .getId());
        });
    }

    public void showItemCards(List<IssueItemCardView> cards) {
        renderItemCards(cards);
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

    @FXML
    public void viewSearchbar() {
        Searchbar search = new Searchbar(searchbar);
        search.viewFront();
    }

    @FXML
    public void initialize() throws IOException,
            InterruptedException {
        // Serve per far comparire l'HBox
        // sotto l'AnchorPane quando
        // si vuole cercare una card.
        searchbar.setViewOrder(1.0);
        configureMaximize(assignmentsbar, Sequence
                .getCurrStage());
        showItemCards(orchestration.issueItem()
                .getAllAssigned(IssueItemCard::new,
                        IssueContentCard::new));
        issues = Integer.parseInt(numIssue
                .getText());
    }

    @FXML
    public void refresh() throws IOException,
            InterruptedException {
        emailBox.setOpacity(0.0);
        clearContainer(cardContainer);
        fade(emailBox);
        showItemCards(orchestration.issueItem()
                .getAllAssigned(IssueItemCard::new,
                        IssueContentCard::new));
    }
}
