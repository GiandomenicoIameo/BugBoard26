package org.example.demo.view.components.card.issue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.demo.view.components.card.issue.definitions.issueContentCard.IssueContentCardView;
import org.example.demo.view.components.card.issue.definitions.issueItemCard.IssueItemCardView;
import org.example.demo.view.core.contract.IssuePriority;
import org.example.demo.view.shared.Date;

import java.time.LocalDateTime;
import java.util.function.Consumer;

public class IssueItemCard extends IssueCard implements IssueItemCardView {
    private static Button currentButton = null;

    private Label current = null;
    private Consumer<IssueContentCardView> callback;
    private IssueContentCardView listener;

    @FXML private Button box;

    @FXML private Label id;
    @FXML private Label name;
    @FXML private Label title;
    @FXML private Label date;

    @FXML private Label low;
    @FXML private Label medium;
    @FXML private Label high;

    public IssueItemCard() {
        show("issue-item.fxml");
    }

    public void setCallback(Consumer<IssueContentCardView> callback) {
        this.callback = callback;
    }

    public void setSelectionListener(IssueContentCardView listener) {
        this.listener = listener;
    }

    public void setId(Integer id) {
        this.id.setText(
                id.toString());
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public void setName(String name) {
        this.name.setText(name);
    }

    public void setDate(LocalDateTime date) {
        Date d = new Date();
        d.setDate(date);
        this.date
                .setText(d.toString());
    }

    public void setPriority(IssuePriority priority) {
        if(IssuePriority
                .ALTA == priority)
            setHigh();
        else if(IssuePriority
                .MEDIA == priority)
            setMedium();
        else if(IssuePriority
                .BASSA == priority)
            setLow();
    }

    private void setLabels(Label labels) {
        if(current != null)
            current.setVisible(false);
        current = labels;
        current.setVisible(true);
    }

    public void setLow() {
        setLabels(low);
    }

    public void setMedium() {
        setLabels(medium);
    }

    public void setHigh() {
        setLabels(high);
    }

    public String getId() {
        return id.getText();
    }

    @FXML
    public void handleOnClick(ActionEvent event) {
        if (currentButton != null && currentButton != box)
            currentButton.getStyleClass()
                    .remove("selected");

        if (box.getStyleClass()
                .contains("selected")) {
            box.getStyleClass()
                    .remove("selected");
            currentButton = null;
        } else {
            box.getStyleClass()
                    .add("selected");
            currentButton = box;
        }

        if (callback != null)
            callback.accept(listener);
    }

    @Override
    public Parent getRoot() {
        return box;
    }
}
