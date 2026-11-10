package org.example.demo.view.components.modal;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.demo.view.components.card.user.NewUserCard;
import org.example.demo.view.components.modal.definitions.NewUserModalView;
import org.example.demo.view.core.Component;
import org.example.demo.view.core.contract.Role;

import java.io.IOException;
import java.util.function.Consumer;

public class NewUserModal extends Component implements NewUserModalView {
    private Consumer<NewUserCard> callback;

    @FXML private VBox newUserModal;

    @FXML private TextField name;
    @FXML private TextField surname;

    @FXML private RadioButton role;

    @FXML private TextField email;
    @FXML private TextField password;

    public NewUserModal() {
        show("new-user-modal.fxml");
    }

    public void setCallback(Consumer<NewUserCard> callback) {
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
        NewUserCard newUserCard = orchestration
                .user()
                .create(this, NewUserCard::new);

        if (callback != null)
            callback.accept(newUserCard);
        close();
    }

    @FXML
    public void close() {
        Stage stage = (Stage) newUserModal
                .getScene().getWindow();
        stage.close();
    }
}
