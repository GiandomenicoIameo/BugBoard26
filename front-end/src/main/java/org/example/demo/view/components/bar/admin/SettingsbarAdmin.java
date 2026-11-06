package org.example.demo.view.components.bar.admin;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.example.demo.view.components.bar.Settingsbar;

public class SettingsbarAdmin extends Settingsbar {
    @FXML private Label admin;

    public SettingsbarAdmin() {
        show("settingsbar.fxml");
    }

    public void setRole() {
        setAdmin();
    }

    public void setAdmin() {
        setLabels(admin);
    }
}
