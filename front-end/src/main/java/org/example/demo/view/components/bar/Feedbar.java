package org.example.demo.view.components.bar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.example.demo.view.components.card.issue.IssueFeedCard;
import org.example.demo.view.components.modal.NewIssueCard;
import org.example.demo.view.components.modal.Filter;
import org.example.demo.view.core.Component;
import org.example.demo.view.core.Sequence;
import org.example.demo.view.core.Session;
import org.example.demo.view.shared.Searchbar;
import java.io.IOException;
import java.util.List;

public class Feedbar extends Component {
    @FXML private AnchorPane feedbar;
    @FXML private VBox cardContainer;
    @FXML private HBox searchbar;
    @FXML private Label issues;
    @FXML private TextField search;

    private List<IssueFeedCard> list;

    public Feedbar() {
        show("feedbar.fxml");
    }

    private void clearContainer() {
        cardContainer.getChildren()
                .clear();
    }

    private void addCard(IssueFeedCard card) {
        card.setViewerRole(Session.role());
        cardContainer.getChildren()
                .add(card.getRoot());
    }

    private void countIssues(int size) {
        issues.setText(Integer
                .toString(size));
    }

    private void render(List<IssueFeedCard> cards) {
        clearContainer();
        cards.forEach(this::addCard);
        countIssues(cards.size());
    }

    private void showCards(List<IssueFeedCard> cards) {
        list = cards;
        render(list);
    }

    private void loadCard(IssueFeedCard card) {
        addCard(card);
        list.add(card);
        countIssues(list.size());
    }

    @Override
    public Parent getRoot() {
        return feedbar;
    }

    private String[] assembleString(String target) {
        String[] partRaw = target
                .split("/", 3);
        String[] part = {"", "", ""};

        System.arraycopy(partRaw, 0,
                part, 0, partRaw.length);
        return part;
    }

    private Filter assembleFilter(
            String[] split) {
        Filter filter = new Filter();

        filter.setKeyword(
                split[0]);
        filter.setTypology(
                split[1]);
        filter.setPriority(
                split[2]);
        return filter;
    }

    @FXML
    public void initialize() throws IOException,
            InterruptedException {
        configureMaximize(feedbar,
                Sequence.getCurrStage());
        showCards(orchestration.issueFeed()
                .getAll(IssueFeedCard::new));
    }

    @FXML
    public void viewSearchbar() {
        Searchbar search = new Searchbar(searchbar);
        search.viewBack();
    }

    @FXML
    public void searchByKeyword() throws IOException,
            InterruptedException {
        String[] part = assembleString(search.getText()
                .toUpperCase());

        showCards(orchestration.issueFilter()
                .getAllBySearch(assembleFilter(part),
                        IssueFeedCard::new));
    }

    @FXML
    public void refresh() throws IOException,
            InterruptedException {
        feedbar.setOpacity(0.0);
        fade(feedbar);
        showCards(orchestration.issueFeed()
                .getAll(IssueFeedCard::new));
    }

    @FXML
    private void onSortedSelected(ActionEvent event) {
        String text = ((MenuItem) event
                .getSource()).getText();
        render("Latest".equals(text) ? list :
                list.reversed());
    }

    @FXML
    public void handleShowIssueFiltered() {
        Filter filter = new Filter();
        addComponent(filter);
        filter.setCallback(
                this::showCards);
        filter.asModal(feedbar);
    }

    @FXML
    public void handleAddIssue() {
        NewIssueCard issue =
                new NewIssueCard();
        addComponent(issue);
        issue.setCallback(
                this::loadCard);
        issue.asModal(feedbar);
    }
}
