package org.example.demo.view.access;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.example.demo.view.View;
import java.io.IOException;

public abstract class Access extends View {
    // La seguente variabile di istanza conterrà la grafica.
    protected Parent view;

    protected Access(String path) {
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().
                getResource(path));

        loader.setController(this);

        try {
            this.view = loader.load();
        } catch (IOException e) {
            throw new RuntimeException("Impossibile " +
                    "caricare la vista", e);
        }
    }

    protected Parent showView() {
        return view;
    }
}
