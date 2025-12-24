package org.example.demo.view.access;

import javafx.scene.Parent;
import org.example.demo.view.View;

public abstract class Access extends View {
    // La seguente variabile di istanza conterrà la grafica
    protected Parent view;

    protected Parent view() {
        return view;
    }
}
