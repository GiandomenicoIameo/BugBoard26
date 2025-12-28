package org.example.demo.view.access;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

class Login extends Access {

    Login() {
        super("login.fxml");
    }

    @FXML
    protected void signUp(ActionEvent e) {
        shiftView(e, new Register());
    }
}
