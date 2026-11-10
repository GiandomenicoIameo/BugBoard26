package org.example.demo.view.components.modal;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.demo.view.components.card.notice.NoticeCard;
import org.example.demo.view.core.Component;
import java.io.IOException;
import java.util.List;

public class Notification extends Component {
    @FXML private VBox notifybar;
    @FXML private VBox containerNew;
    @FXML private Label numNotice;

    public Notification() {
        show("notifybar.fxml");
    }

    private void countNotices(int size) {
        numNotice.setText(Integer
                .toString(size));
    }

    public void importCard() throws IOException,
            InterruptedException {
        List<NoticeCard> list = orchestration
                .notice()
                .getAll(NoticeCard::new);

        list.forEach(card ->
            containerNew
                    .getChildren()
                    .add(card.getRoot())
        ); countNotices(list
                .size());
    }

    public Parent getRoot() {
        return notifybar;
    }

    @FXML
    public void initialize() throws IOException,
            InterruptedException {
        importCard();
    }

    @FXML
    public void close() {
        Stage stage = (Stage) notifybar
                .getScene()
                .getWindow();
        stage.close();
    }
}
