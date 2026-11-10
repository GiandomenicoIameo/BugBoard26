package org.example.demo.view.components.bar.admin;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import org.example.demo.view.components.card.user.NewUserCard;
import org.example.demo.view.components.modal.NewUserModal;
import org.example.demo.view.core.Component;

import java.io.IOException;
import java.util.List;

public class Groupbar extends Component {
    @FXML private VBox groupbar;
    @FXML private VBox cardContainer;
    @FXML private Label useraccounts;
    @FXML private ScrollPane scroll;

    private int issues = 0;

    public Groupbar() {
        show("groupbar.fxml");
    }

    public void countIssues(int size) {
        useraccounts.setText(Integer
                .toString(size));
        issues = size;
    }

    public void importCards() throws IOException,
            InterruptedException {
        populateContainer(orchestration.user()
                .getAll(NewUserCard::new));
    }

    public void populateContainer(List<NewUserCard> list) {
        scroll.setVisible(true);
        list.forEach(card -> cardContainer
                .getChildren()
                .add(card.getRoot()));
        countIssues(list.size());
    }

    private void loadCard(NewUserCard newUserCard) {
        scroll.setVisible(true);
        cardContainer.getChildren().
                add(newUserCard.getRoot());
        countIssues(++issues);
    }

    @FXML
    public void initialize() throws IOException,
            InterruptedException {
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
        NewUserModal newUserModal = new
                NewUserModal();
        addComponent(newUserModal);
        newUserModal.setCallback(
                this::loadCard);
        newUserModal.asModal(groupbar);
    }

    @Override
    public Parent getRoot() {
        return groupbar;
    }
}
