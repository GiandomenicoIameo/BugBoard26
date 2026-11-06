package org.example.demo.view.components.bar.admin;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import org.example.demo.view.components.card.user.User;
import org.example.demo.view.components.modal.NewUserCard;
import org.example.demo.view.core.Component;
import org.example.demo.view.core.Sequence;

import java.io.IOException;
import java.util.List;

public class Groupbar extends Component {
    @FXML private VBox groupbar;
    @FXML private VBox cardContainer;
    @FXML private Label useraccounts;
    @FXML private ScrollPane scroll;

    private int numIssues = 0;

    public Groupbar() {
        show("groupbar.fxml");
    }

    public void countIssues(int size) {
        useraccounts.setText(Integer
                .toString(size));
        numIssues = size;
    }

    public void importCards() throws IOException,
            InterruptedException {
        scroll.setSnapToPixel(true);
        cardContainer.setSnapToPixel(true);
        populateContainer(orchestration.user()
                .getAll(User::new));
    }

    public void populateContainer(List<User> list) {
        scroll.setVisible(true);
        list.forEach(card -> cardContainer
                .getChildren()
                .add(card.getRoot()));
        countIssues(list.size());
    }

    private void loadCard(User user) {
        scroll.setVisible(true);
            cardContainer.getChildren().
                    add(user.getRoot());
            countIssues(++numIssues);
    }

    @FXML
    public void initialize() throws IOException,
            InterruptedException {
        configureMaximize(groupbar, Sequence
                .getCurrStage());
        importCards();
    }

    @FXML
    public void refresh() throws IOException,
            InterruptedException {
        groupbar.setOpacity(0.0);
        cardContainer.getChildren()
                .clear();
        fade(groupbar);
        importCards();
    }

    @FXML
    public void handleAdd() {
        NewUserCard newUserCard = new
                NewUserCard();
        addComponent(newUserCard);
        newUserCard.setCallback(
                this::loadCard);
        newUserCard.asModal(groupbar);
    }

    @Override
    public Parent getRoot() {
        return groupbar;
    }
}
