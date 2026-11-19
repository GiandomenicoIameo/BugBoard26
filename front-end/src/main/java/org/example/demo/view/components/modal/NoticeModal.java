package org.example.demo.view.components.modal;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.demo.view.components.card.notice.NoticeCard;
import org.example.demo.view.core.Component;
import java.io.IOException;
import java.util.List;

public class NoticeModal extends Component {
    @FXML private VBox noticeModal;
    @FXML private VBox containerNew;
    @FXML private Label numNotice;
    @FXML private HBox noNotice;
    @FXML private HBox boxLabelNew;

    public NoticeModal() {
        show("notice-modal.fxml");
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

        if(list.isEmpty()) {
            boxLabelNew.setVisible(false);
            boxLabelNew.setManaged(false);

            containerNew.setVisible(false);
            containerNew.setManaged(false);

            noNotice.setVisible(true);
            noNotice.setManaged(true);

            return;
        }

        for (int i = 0; i < list.size(); i++) {
            NoticeCard card = list.get(i);

            if (i == list.size() - 1)
                card.getRoot()
                        .setStyle("-fx-border-color: transparent;");

            if (card.getRoot() != null) {
                containerNew.getChildren()
                        .add(card.getRoot());
            }
        }
        countNotices(list
                .size());
    }

    public Parent getRoot() {
        return noticeModal;
    }

    @FXML
    public void initialize() throws IOException,
            InterruptedException {
        importCard();
    }

    @FXML
    public void close() {
        Stage stage = (Stage) noticeModal
                .getScene()
                .getWindow();
        stage.close();
    }
}
