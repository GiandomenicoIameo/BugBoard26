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

    @FXML private Label issues;
    @FXML private Label id;

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
        issues.setText(size
                .toString());
    }

    private void addItemCard(IssueItemCardView card) {
        cardContainer.getChildren()
                .add(card.getRoot());
    }

    private void renderItemCards(List<IssueItemCardView> cards) {
        clearContainer(cardContainer);
        for (IssueItemCardView card : cards) {
            onAction(card); addItemCard(card);
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
            id.setText(card.getId());
        });
    }

    public void showItemCards(List<IssueItemCardView> cards) {
        renderItemCards(cards);
    }

    @FXML
    public void onSearch() {
        searchBug(search.getText()
                .toLowerCase());
    }

    public void searchBug(String target) {
        int visible = 0;

        for (Node node : cardContainer.getChildren()) {
            if (node instanceof Button card) {
                boolean match = setVisibleCard(target, (Label)
                        card.lookup("#name"));
                setShown(card, match);
                if (match) visible++;
            }
        } countIssues(visible);
    }

    private void setShown(Node node, boolean shown) {
        node.setVisible(shown);
        node.setManaged(shown);
    }

    private boolean setVisibleCard(String target, Label name) {
        return target.isEmpty() || name.getText()
                .toLowerCase().equals(target);
    }

    @FXML
    public void viewSearchbar() {
        Searchbar search = new Searchbar(searchbar);
        search.viewFront();
        search.setOnFinished(() -> {this
                .search.clear();
                searchBug("");
        });
    }

    @FXML
    public void initialize() throws IOException,
            InterruptedException {
        // Serve per far comparire l'HBox
        // sotto l'AnchorPane quando
        // si vuole cercare una card.
        searchbar.setViewOrder(1.0);
        showItemCards(orchestration.issueItem()
                .getAllAssigned(IssueItemCard::new,
                        IssueContentCard::new));
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
