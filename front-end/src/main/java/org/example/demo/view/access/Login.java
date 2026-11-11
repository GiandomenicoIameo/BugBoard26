package org.example.demo.view.access;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.example.demo.view.access.definitions.LoginView;
import org.example.demo.view.access.factory.DockFactory;
import org.example.demo.view.core.View;
import org.example.demo.view.core.contract.Role;
import java.util.Map;

public class Login extends View implements LoginView {
    private final Map<Role, DockFactory> map;

    @FXML private AnchorPane    login;
    @FXML private TextField     email;
    @FXML private PasswordField password;
    @FXML private ProgressIndicator progress;
    @FXML private Button signIn;

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

    private void setLoadingState(boolean state) {
        signIn.setMouseTransparent(state);
        progress.setVisible(state);

        if(state)
            signIn.setText("");
        else
            signIn.setText("Sign in");
    }

    @FXML
    public void initialize() {
        setLoadingState(false);
    }

    @FXML
    public void signIn() {
        setLoadingState(true);

        Task<DockFactory> task = new Task<>() {
            @Override
            protected DockFactory call()
                    throws Exception {
                return map.get(
                        orchestration.login()
                                .login(Login.this));
            }
        };

        task.setOnSucceeded(e -> {
            DockFactory dockFactory = task
                    .getValue();
            setLoadingState(false);

            if (dockFactory != null) {
                setLogin();
                Platform.runLater(dockFactory::
                        createDock);
            } // else {
            // non esiste quel ruolo o le credenziali sono errate!
            // }
        });

        // Il fallimento (setOnFailed) in un Task di JavaFX
        // si verifica quando all'interno del metodo call()
        // viene lanciata un'eccezione non gestita (cioè un errore
        // che blocca l'esecuzione).
        // In questo caso, il fallimento si verifica quando accade
        // uno dei seguenti eventi: problemi di connessione,
        // server Docker spento, interruzioni forzate del thread.
        task.setOnFailed(e -> {
            setLoadingState(false);
            Throwable ex = task.getException();
            if (ex != null)
                ex.printStackTrace();
        });

        new Thread(task).start();
    }
}
