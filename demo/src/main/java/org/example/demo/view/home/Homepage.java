package org.example.demo.view.home;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import org.example.demo.view.View;

public abstract class Homepage extends View {

    protected Parent view;

    public static Homepage createRegular() {
        return new Regular();
    }

    public static Homepage createAdministrator() {
        return new Administrator();
    }

    @FXML
    protected void signOut(ActionEvent e) {
        System.exit( 0 );
    }

    public Parent show() {
        return view;
    }
}