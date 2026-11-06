package org.example.demo.view.components.bar.admin;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.example.demo.view.components.bar.Settingsbar;

public class SettingsbarAdmin extends Settingsbar {
    public SettingsbarAdmin() {
        show("settingsbar.fxml");
    }

    @FXML private Label admin;;

    public void setRole() {
        setAdmin();
    }

    public void setAdmin() {
        setLabels(admin);
    }
}
