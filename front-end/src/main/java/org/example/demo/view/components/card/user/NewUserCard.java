package org.example.demo.view.components.card.user;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.example.demo.view.components.card.Card;
import org.example.demo.view.components.card.user.definitions.NewUserCardView;
import org.example.demo.view.core.contract.Role;

public class NewNewUserCard extends Card implements NewUserCardView {
    @FXML private HBox account;
    @FXML private VBox cardContainer;

    @FXML private Label admin;
    @FXML private Label user;
    @FXML private Label userBold;
    @FXML private Label userRegular;
    @FXML private Label email;

    private Label current = null;

    public NewNewUserCard() {
        show("user.fxml");
    }

    public void setUsernameBold(String username) {
        userBold.setText(username);
    }

    public void setUsernameRegular(String username) {
        userRegular.setText(username);
    }

    public void setEmail(String email) {
        this.email
                .setText(email);
    }

    public void setRole(String role) {
        if(role.equals(Role
                .AMMINISTRATORE.name()))
            setAdmin();
        else
            setUser();
    }

    private void setLabels(Label labels) {
        if(current != null)
            current.setVisible(false);
        current = labels;
        current.setVisible(true);
    }

    private void setAdmin() {
        setLabels(admin);
    }

    private void setUser() {
        setLabels(user);
    }

    @Override
    public Parent getRoot() {
        return account;
    }
}
