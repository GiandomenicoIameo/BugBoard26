package org.example.demo.view.components.card.user;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import org.example.demo.view.components.card.Card;
import org.example.demo.view.components.card.user.definitions.PrompterView;

public class Prompter extends Card implements PrompterView {
    @FXML private HBox prompter;

    @FXML private Label nameSurname;
    @FXML private Label name;
    @FXML private Label email;
    @FXML private Label id;

    @FXML private RadioButton radio;

    public Prompter() {
        show("prompter.fxml");
    }

    public void setId(Integer id) {
        if (radio != null)
            radio.setUserData(id);
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname
                .setText(nameSurname);
    }

    public void setName(String name) {
        this.name.setText(name);
    }

    public void setEmail(String email) {
        this.email.setText(email);
    }

    public Object getUserData() {
        return radio != null ? radio
                .getUserData() : null;
    }

    public void setToggleGroup(ToggleGroup group) {
        if (radio != null)
            radio.setToggleGroup(group);
    }

    @Override
    public Parent getRoot() {
        return prompter;
    }
}
