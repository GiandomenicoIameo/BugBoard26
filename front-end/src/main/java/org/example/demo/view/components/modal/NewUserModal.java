package org.example.demo.view.components.modal;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.demo.view.components.card.user.UserCard;
import org.example.demo.view.components.modal.definitions.NewUserCardView;
import org.example.demo.view.core.Component;
import org.example.demo.view.core.contract.Role;

import java.io.IOException;
import java.util.function.Consumer;

public class NewUserCard extends Component implements NewUserCardView {
    private Consumer<UserCard> callback;

    @FXML private VBox newUserCard;

    @FXML private TextField name;
    @FXML private TextField surname;

    @FXML private RadioButton role;

    @FXML private TextField email;
    @FXML private TextField password;

    public NewUserCard() {
        show("add-user.fxml");
    }

    public void setCallback(Consumer<UserCard> callback) {
        this.callback = callback;
    }

    public String getName() {
        return name.getText();
    }

    public String getSurname() {
        return surname.getText();
    }

    public String getRole() {
        if (role.isSelected())
            return role.getUserData()
                    .toString();
        return Role.NORMALE
                .name();
    }

    public String getEmail() {
        return email.getText();
    }

    public String getPassword() {
        return password.getText();
    }

    @FXML
    public void handleAdd() throws IOException,
            InterruptedException {
        UserCard userCard = orchestration
                .user()
                .create(this, UserCard::new);

        if (callback != null)
            callback.accept(userCard);
        close();
    }

    @FXML
    public void close() {
        Stage stage = (Stage) newUserCard
                .getScene().getWindow();
        stage.close();
    }
}
