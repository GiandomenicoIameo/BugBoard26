package org.example.demo.view.home;

import javafx.fxml.FXMLLoader;
import java.io.IOException;


class Regular extends Homepage {

    Regular() {

        FXMLLoader loader;
        loader = new FXMLLoader(getClass().
                getResource("regular-homepage.fxml"));

        loader.setController(this);

        try {
            this.view = loader.load();
        } catch (IOException e) {
            throw new RuntimeException("Impossibile " +
                    "caricare la vista", e);
        }
    }
}
