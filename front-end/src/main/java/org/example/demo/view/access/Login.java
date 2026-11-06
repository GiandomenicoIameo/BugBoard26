package org.example.demo.view.access;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.example.demo.view.access.definitions.LoginView;
import org.example.demo.view.access.factory.DockFactory;
import org.example.demo.view.core.Sequence;
import org.example.demo.view.core.View;
import org.example.demo.view.core.contract.Role;
import java.io.IOException;
import java.util.Map;

public class Login extends View implements LoginView {
    private final Map<Role, DockFactory> map;

    @FXML private AnchorPane    login;
    @FXML private TextField     email;
    @FXML private PasswordField password;

    public Login(Map<Role, DockFactory> map) {
        show("login.fxml");
        this.map = map;
    }

    public String getEmail() {
        return email.getText();
    }

    public String getPassword() {
        return password.getText();
    }

    private void setLogin() {
        orchestration.login()
                .setPageLogin(() ->
                        show("login.fxml"));
    }

    @FXML
    public void initialize() {
        configureMaximize(login, Sequence
                .getCurrStage());
    }

    @FXML
    public void signIn() throws IOException,
            InterruptedException {

        DockFactory dockFactory = map
                .get(orchestration.login()
                        .login(this));

        if (dockFactory != null) {
            setLogin();
            Platform.runLater(dockFactory::
                    createDock);
       }
        // else {
        // non esiste quel ruolo!
        // }
    }
}
