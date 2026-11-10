package org.example.demo.view.components.modal;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.demo.view.components.card.user.PrompterUserCard;
import org.example.demo.view.core.Component;
import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

public class AssignIssueModal extends Component {
    private Integer bugId;
    private Consumer<Boolean> callback;

    private ToggleGroup group =
            new ToggleGroup();

    @FXML private AnchorPane assignIssueModal;
    @FXML private VBox cardContainer;
    @FXML private ScrollPane scroll;

    public AssignIssueModal() {
        show("assign-issue-modal.fxml");
    }

    @FXML
    public void initialize() throws IOException,
            InterruptedException {
        importCard();
    }

    public void setCallback(Consumer<Boolean> callback) {
        this.callback = callback;
    }

    public void setBugId(int bugId) {
        this.bugId = bugId;
    }

    public void importCard() throws IOException,
            InterruptedException {
        List<PrompterUserCard> list = orchestration.user()
                .getAllSuggested(PrompterUserCard::new);

        scroll.setVisible(true);
        list.forEach(prompterCard -> {
            prompterCard.setToggleGroup(group);
            cardContainer.getChildren().
                    add(prompterCard.getRoot());
        });
    }

    @FXML
    public void handleAssign() throws IOException,
            InterruptedException {
        Integer userId = null;

        if (group.getSelectedToggle() != null)
            userId = (Integer) group
                    .getSelectedToggle().getUserData();

        if (callback != null)
            callback.accept(orchestration.issueFeed()
                    .assigned(bugId, userId));
        close();
    }

    @FXML
    public void close() {
        Stage stage = (Stage) assignIssueModal
                .getScene().getWindow();
        stage.close();
    }
}
