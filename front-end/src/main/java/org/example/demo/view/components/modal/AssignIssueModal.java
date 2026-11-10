package org.example.demo.view.components.modal;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.demo.view.components.card.user.Prompter;
import org.example.demo.view.core.Component;
import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

public class Assignment extends Component {
    private Integer bugId;
    private Consumer<Boolean> callback;

    private ToggleGroup group =
            new ToggleGroup();

    @FXML private AnchorPane assignment;
    @FXML private VBox cardContainer;
    @FXML private ScrollPane scroll;

    public Assignment() {
        show("assignment.fxml");
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
        List<Prompter> list = orchestration.user()
                .getAllSuggested(Prompter::new);

        scroll.setVisible(true);
        list.forEach(prompter -> {
            prompter.setToggleGroup(group);
            cardContainer.getChildren().
                    add(prompter.getRoot());
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
        Stage stage = (Stage) assignment
                .getScene().getWindow();
        stage.close();
    }
}
