package org.example.demo.view.components.card.notice;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.example.demo.view.components.card.Card;
import org.example.demo.view.components.card.notice.definitions.NoticeView;
import org.example.demo.view.shared.Date;
import java.time.LocalDateTime;

public class Notice extends Card implements NoticeView {
    @FXML private HBox notice;

    @FXML private Label id;
    @FXML protected Label date;
    @FXML private Label newNotice;

    public Notice() {
        show("notice.fxml");
    }

    public void setId(Integer id) {
        this.id.setText(id.toString());
    }

    public void setDate(LocalDateTime date) {
        Date d = new Date();
        d.setDate(date);
        this.date.setText(d.toString());
    }

    public void setRead(boolean read) {
        newNotice.setManaged(read);
        newNotice.setVisible(read);
    }

    @Override
    public Parent getRoot() {
        return notice;
    }
}
