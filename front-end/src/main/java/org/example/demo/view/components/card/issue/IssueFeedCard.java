package org.example.demo.view.components.card.issue;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import org.example.demo.view.components.card.issue.definitions.issueFeedCard.IssueFeedCardView;
import org.example.demo.view.components.modal.Assignment;
import org.example.demo.view.core.Session;
import org.example.demo.view.core.contract.IssuePriority;
import org.example.demo.view.core.contract.IssueState;
import org.example.demo.view.core.contract.IssueTypology;
import org.example.demo.view.core.contract.Role;
import java.io.IOException;

public class IssueFeedCard extends IssueCard implements IssueFeedCardView {
    @FXML private VBox issueCard;

    @FXML private Label id;
    @FXML private Label name;
    @FXML private Label title;

    private IssueTypology tupologia; // per il test
    @FXML private Label bug;
    @FXML private Label feature;
    @FXML private Label question;
    @FXML private Label documentation;

    private IssuePriority priorita; // per il test
    @FXML private Label low;
    @FXML private Label medium;
    @FXML private Label high;

    @FXML private Label assigned;

    @FXML private Label duplicate;
    @FXML private MenuButton options;
    @FXML private MenuButton issueClose;

    private IssueState stato; // per il test
    @FXML private Region state;
    @FXML private MenuItem close;

    private Label typology = null;
    private Label priority = null;
    private Role viewerRole;

    public IssueFeedCard() {
        show("issue-feed.fxml");
    }

    public void setId(Integer id) {
        close.setUserData(id);
        duplicate.setUserData(id);
        this.id.setText(
                id.toString());
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public void setName(String name) {
        this.name.setText(name);
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
        priorita = priority;
    }

    public void setTypology(IssueTypology typology) {
        if(IssueTypology
                .BUG == typology) {
            setBug();
            setVisibleMenu(true);
        }
        else if(IssueTypology
                .FEATURE == typology)
            setFeature();
        else if(IssueTypology
                .DOCUMENTATION == typology)
            setDocumentation();
        else if(IssueTypology
                .QUESTION  == typology)
            setQuestion();
        tupologia = typology;
    }

    public void setState(IssueState state) {
        if(IssueState.TODO == state)
            setStateTodo();
        else
            setStateClosed();
        stato = state;
    }

    public void setDuplicated(boolean duplicated) {
        boolean visible = Role.AMMINISTRATORE ==
                Session.role();

        this.duplicate.setManaged(visible
                && duplicated);
        this.duplicate.setVisible(visible
                && duplicated);
    }

    public void setAssignee(boolean assigned) {
        boolean visible = Role.AMMINISTRATORE ==
                Session.role();

        this.assigned.setManaged(visible
                && assigned);
        this.assigned.setVisible(visible
                && assigned);
    }

    public void setCardRegular() {
        setVisibleCloseIssue(false);
        setVisibleMenu(false);
    }

    private void setVisibleCloseIssue(boolean close) {
        issueClose.setManaged(close);
        issueClose.setVisible(close);
    }

    private void setVisibleMenu(boolean menu) {
        options.setManaged(menu);
        options.setVisible(menu);
    }

    private void setLabels(Label type, Label value) {
        if(type != null) {
            type.setManaged(false);
            type.setVisible(false);
        }
        type = value;
        type.setManaged(true);
        type.setVisible(true);
    }

    private void setBug() {
        setLabels(typology,
                bug);
    }

    private void setFeature() {
        setLabels(typology,
                feature);
    }

    private void setDocumentation() {
        setLabels(typology,
                documentation);
    }

    private void setQuestion() {
        setLabels(typology,
                question);
    }

    private void setLow() {
        setLabels(priority,
                low);
    }

    private void setMedium() {
        setLabels(priority,
                medium);
    }

    private void setHigh() {
        setLabels(priority,
                high);
    }

    // Qui il controllo sullo stato non
    // deve essere fatto. Se setState
    // effettuasse un controllo come
    // equals("CHIUSO"), conoscerebbe
    // il formato del backend, e se il
    // backend cambia anche la grafica
    // deve cambiare.
    private void setStateTodo() {
        state.getStyleClass().
                add("icon-bell-card-issue");
    }

    private void setStateClosed() {
        state.getStyleClass()
                .add("icon-bell-close-issue");
        setVisibleMenu(false);
        setVisibleCloseIssue(false);
    }

    public void setViewerRole(Role viewerRole) {
        this.viewerRole = viewerRole;

        if(Role.NORMALE == viewerRole)
            setCardRegular();
    }

    public IssuePriority getPriority() {
        return priorita;
    }

    public IssueTypology getTypology() {
        return tupologia;
    }

    public IssueState getState() {
        return stato;
    }

    @Override
    public Parent getRoot() {
        return issueCard;
    }

    @FXML
    public void showAssignment() {
        Assignment assignment =
                new Assignment();
        addComponent(assignment);
        assignment.setBugId(Integer.
                parseInt(id.getText()));
        assignment.setCallback(
                this::setAssignee);
        assignment.asModal(issueCard);
    }

    @FXML
    public void closed() throws IOException,
            InterruptedException {
        IssueFeedCard issue = orchestration.issueFeed()
                .close(Integer.parseInt(
                        id.getText()),
                        new IssueFeedCard());
        setStateClosed();
    }

    @FXML
    public void duplicated() throws IOException,
            InterruptedException {
        IssueFeedCard issue = orchestration.issueFeed()
                .duplicate(Integer.parseInt(
                        id.getText()),
                        new IssueFeedCard());
        setDuplicated(true);
        setStateClosed();
    }
}