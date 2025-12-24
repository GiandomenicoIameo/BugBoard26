package org.example.demo.view.access;

import javafx.fxml.FXMLLoader;
import java.io.IOException;

class Login extends Access {

    public Login() {
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().
                getResource("login.fxml"));

        loader.setController(this);

        try {
            this.view = loader.load();
        } catch (IOException e) {
            throw new RuntimeException("Impossibile " +
                    "caricare la vista", e);
        }
    }
}
