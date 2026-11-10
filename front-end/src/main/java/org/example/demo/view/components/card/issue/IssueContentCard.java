package org.example.demo.view.components.card.issue;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.example.demo.view.components.card.issue.definitions.issueContentCard.IssueContentCardView;
import org.example.demo.view.core.contract.IssueState;
import org.example.demo.view.shared.Date;
import java.time.LocalDateTime;

public class IssueContentCard extends IssueCard implements IssueContentCardView {
    @FXML private VBox issueContentCard;

    @FXML private Label name;
    @FXML private Label title;
    @FXML private Label date;

    @FXML private Label nameCard;
    @FXML private Label dateCard;
    @FXML private Text description;
    @FXML private ImageView image;

    @FXML private Label open;
    @FXML private Label closed;
    @FXML private Label duplicate;

    @FXML private VBox boxImage;

    public IssueContentCard() {
        show("issue-content-card.fxml");
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public void setName(String name) {
        this.name.setText(name);
    }

    public void setDescpription(String descpription) {
        this.description.setText(descpription);
    }

    public void setDate(LocalDateTime date) {
        Date d = new Date();
        d.setDate(date);
        this.date.setText(d.toString());
    }

    private void setVisibleBoxImage(boolean isVisible) {
        boxImage.setVisible(isVisible);
        boxImage.setManaged(isVisible);
    }

    public void setImage(Integer id) {
        Image photo = orchestration
                .issueItem().loadImage(id);

        setVisibleBoxImage(photo != null);
        image.setImage(photo);
    }

    public void setNameCard(String name) {
        nameCard.setText(name);
    }

    public void setDateCard(LocalDateTime date) {
        Date d = new Date();
        d.setDate(date);
        this.date.setText(d
                .toString());
        this.dateCard.setText(d
                .toString());
    }

    public void setState(IssueState state) {
        setClose(IssueState.CHIUSO == state);
    }

    public void setClose(boolean close) {
        closed.setManaged(close);
        closed.setVisible(close);

        open.setManaged(!close);
        open.setVisible(!close);
    }

    public void setDuplicated(boolean duplicated) {
        duplicate.setManaged(duplicated);
        duplicate.setVisible(duplicated);
    }

    @Override
    public Parent getRoot() {
        return issueContentCard;
    }
}
