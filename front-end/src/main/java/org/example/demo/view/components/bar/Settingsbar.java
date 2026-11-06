package org.example.demo.view.components.bar;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import org.example.demo.view.core.Component;
import org.example.demo.view.core.Sequence;
import java.io.IOException;

public abstract class Settingsbar extends Component {
    @FXML private VBox settingsbar;
    @FXML private Pane avatarPane;

    @FXML private Label name;
    @FXML private Label email;

    private Label current = null;

    public abstract void setRole();

    public void setName(String name) {
        this.name.setText(name);
    }

    public void setEmail(String email) {
        this.email.setText(email);
    }

    protected void setLabels(Label labels) {
        if(current != null) {
            current.setManaged(false);
            current.setVisible(false);
        }
        current = labels;
        current.setManaged(true);
        current.setVisible(true);
    }

    public void showRole() throws IOException,
            InterruptedException {
        orchestration.user()
                .getMe(this);
    }

    @Override
    public Parent getRoot() {
        return settingsbar;
    }

    @FXML
    public void initialize() throws IOException,
            InterruptedException {
        Circle clip = new Circle(80, 80, 80);
        avatarPane.setClip(clip);
        showRole();
    }
}
