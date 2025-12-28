package org.example.demo.view.access;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

class Register extends Access {

    Register() {
        super("register.fxml");
    }

    @FXML
    protected void signIn(ActionEvent e) {
        shiftView(e, new Login());
    }
}
