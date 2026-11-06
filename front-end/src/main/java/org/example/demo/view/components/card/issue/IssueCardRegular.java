package org.example.demo.view.components.card.issue;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import org.example.demo.view.components.card.Card;

public class IssueCardRegular extends Card {
    @FXML private VBox issueCard;

    @FXML private Label id;
    @FXML private Label username;
    @FXML private Label title;

    @FXML private Label bug;
    @FXML private Label feature;
    @FXML private Label question;
    @FXML private Label documentation;

    @FXML private Label low;
    @FXML private Label medium;
    @FXML private Label high;

    private Label typology = null;
    private Label priority = null;

    public IssueCardRegular() {
        FXMLLoader loader = new FXMLLoader(getClass().
                getResource("issue-regular.fxml"));
        loader.setController(this);
        try {
            loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setLabels(Label type, Label value) {
        if(type != null)
            type.setVisible(false);
        type = value;
        type.setVisible(true);
    }

    public void setBug() {
        setLabels(typology,
                bug);
    }

    public void setFeature() {
        setLabels(typology,
                feature);
    }

    public void setDocumentation() {
        setLabels(typology,
                documentation);
    }

    public void setQuestion() {
        setLabels(typology,
                question);
    }

    public void setLow() {
        setLabels(priority,
                low);
    }

    public void setMedium() {
        setLabels(priority,
                medium);
    }

    public void setHigh() {
        setLabels(priority,
                high);
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public void setId(Integer id) {
        this.id.setText(
                id.toString());
    }

    public void setUsername(String username) {
        this.username.setText(username);
    }

    @Override
    public Parent getRoot() {
        return issueCard;
    }
}