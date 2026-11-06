package org.example.demo.view.components.bar.regular;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.example.demo.view.components.bar.Settingsbar;

public class SettingsbarRegular extends Settingsbar {
    @FXML private Label user;

    public SettingsbarRegular() {
        show("settingsbar.fxml");
    }

    public void setUser() {
        setLabels(user);
    }

    public void setRole() {
        setUser();
    }
}
