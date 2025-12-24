package org.example.demo.view.home;

import javafx.fxml.FXMLLoader;
import java.io.IOException;

class Administrator extends Homepage {

    Administrator() {

        FXMLLoader loader;
        loader = new FXMLLoader(getClass().
                getResource("admin-homepage.fxml"));

        loader.setController(this);

        try {
            this.view = loader.load();
        } catch (IOException e) {
            throw new RuntimeException("Impossibile " +
                    "caricare la vista", e);
        }
    }
}
