package org.example.demo.view.components.modal;

import javafx.fxml.FXML;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.demo.view.components.card.issue.IssueFeedCard;
import org.example.demo.view.components.modal.definitions.FilterModalView;
import org.example.demo.view.core.Component;
import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

public class FilterModal extends Component implements FilterModalView {
    @FXML private AnchorPane filterModal;

    private String keyword;
    @FXML private ToggleGroup priorityGroup;
    @FXML private ToggleGroup stateGroup;
    @FXML private ToggleGroup typeGroup;

    private Consumer<List<
            IssueFeedCard>> callback;

    public FilterModal() {
        show("filter-modal.fxml");
    }

    public void setCallback(Consumer<
            List<IssueFeedCard>> callback) {
        this.callback = callback;
    }

    private void setGroup(ToggleGroup group,
                         String roleValue) {
        if (roleValue == null || roleValue
                .isEmpty()) {
            group.selectToggle(null);
            return;
        }

        for(Toggle toggle : group.getToggles()) {
            if((roleValue.equals(toggle
                    .getUserData()))) {
                group.selectToggle(toggle);
                break;
            }
        }
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setPriority(String priority) {
        setGroup(priorityGroup, priority);
    }

    public void setTypology(String typology) {
        setGroup(typeGroup, typology);
    }

    public void setState(String state) {
        setGroup(stateGroup, state);
    }

    public String getKeyword() {
        return keyword;
    }

    private String getLabels(Toggle toggle) {
        if(toggle != null)
            return toggle.getUserData()
                    .toString();
        return null;
    }

    public String getPriority() {
        return getLabels(priorityGroup
                .getSelectedToggle());
    }

    public String getTypology() {
        return getLabels(typeGroup
                .getSelectedToggle());
    }

    public String getState() {
        return getLabels(stateGroup
                .getSelectedToggle());
    }

    @FXML
    public void search() throws IOException,
            InterruptedException {

        List<IssueFeedCard> list = orchestration
                .issueFilter()
                .getAll(this, IssueFeedCard::new);

        if(callback != null)
            callback.accept(list);
        close();
    }

    @FXML
    public void close() {
        Stage stage = (Stage) filterModal
                .getScene().getWindow();
        stage.close();
    }

    public void clear() {
        this.callback = null;
    }
}
