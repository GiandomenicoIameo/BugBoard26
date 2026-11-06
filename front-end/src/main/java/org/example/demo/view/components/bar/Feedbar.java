package org.example.demo.view.components.bar;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import org.example.demo.view.components.card.issue.IssueFeedCard;
import org.example.demo.view.components.modal.NewIssueCard;
import org.example.demo.view.components.modal.Filter;
import org.example.demo.view.core.Component;
import org.example.demo.view.core.Sequence;
import org.example.demo.view.core.Session;
import org.example.demo.view.core.contract.Role;

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

    @FXML
    public void initialize() throws IOException,
            InterruptedException {
        setDefaultButton();
        enableMaximize();
        importAllIssues();
    }

    public void setDefaultButton() {
        search.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                try {
                    searchByKeyword();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public void enableMaximize() {
        configureMaximize(feedbar,
                Sequence.getCurrStage());
    }

    @FXML
    public void refresh() throws IOException,
            InterruptedException {
        feedbar.setOpacity(0.0);
        cardContainer.getChildren()
                .clear();
        fade(feedbar);
        importAllIssues();
    }

    @FXML
    private void handleSceltaMenu(ActionEvent event) {
        MenuItem options = (MenuItem)
                event.getSource();
        String testo = options.getText();

        clearContainer();
        if (testo.equals("Latest"))
            sorted(list);
        else
            sorted(list.reversed());
    }

    public void sorted(List<IssueFeedCard> list) {
        for(IssueFeedCard issue : list) {
             if(Role.NORMALE == Session.role())
                issue.setCardRegular();

            cardContainer.getChildren().
                    add(issue.getRoot());
        }
    }

    public void importAllIssues() throws IOException,
            InterruptedException {
        clearContainer();
        populateCards(orchestration.issueFeed()
                .getAll(IssueFeedCard::new));
    }

    private void populateCards(List<IssueFeedCard> listCard) {
        this.list = listCard;

        listCard.forEach(card -> {
            if(Role.NORMALE == Session.role())
                card.setCardRegular();

            cardContainer.getChildren()
                    .add(card.getRoot());
        }); countIssues(listCard
                .size());
    }

    private void loadCard(IssueFeedCard issue) {
        cardContainer.getChildren().
                add(issue.getRoot());
        list.add(issue);
        countIssues(list.size());
    }

    public void clearContainer() {
        cardContainer.getChildren()
                .clear();
    }

    public void countIssues(int size) {
        issues.setText(Integer
                .toString(size));
    }

    public void viewSearchbar() {
        if (!searchbar.isVisible()) {
            searchbar.setVisible(true);
            searchbar.setManaged(true);
            searchbar.toBack();

            // 1. FORZA IL LAYOUT: dice a JavaFX di calcolare subito dimensioni e posizione
            searchbar.applyCss();
            searchbar.layout();
            searchbar.layout();

            // 2. Ora l'altezza è reale e precisa al pixel
            double altezza = searchbar.getHeight();
            if (altezza == 0) {
                altezza = searchbar.prefHeight(-1); // Fallback sicuro basato sul preferred height
            }

            final double finalAltezza =altezza; // Necessario per usarla dentro la lambda

            Platform.runLater(() -> {
                // Partiamo da -finalAltezza e arriviamo a 0 (scende)
                TranslateTransition scendi = translate((int) -finalAltezza, 0);
                scendi.setOnFinished(event -> {
                    searchbar.toFront();
                });
                scendi.play();
            });

        } else {
            searchbar.toBack();

            // Anche in chiusura ci assicuriamo di prendere l'altezza corretta
            searchbar.applyCss();
            searchbar.layout();

            double altezza = searchbar.getHeight();
            if (altezza == 0) altezza = searchbar.prefHeight(-1);

            // Da 0 risale a -altezza
            TranslateTransition sali = translate(0, (int) -altezza);
            sali.setOnFinished(event -> {
                searchbar.setVisible(false);
                searchbar.setManaged(false);
                // Opzionale ma consigliato: resetta la traslazione per pulire lo stato
                searchbar.setTranslateY(0);
            });

            sali.play();
        }
    }

    private TranslateTransition translate(int src, int dst) {
        TranslateTransition move = new TranslateTransition(
                Duration.seconds(0.3), searchbar);
        move.setFromY(src);
        move.setToY(dst);

        return move;
    }

    @Override
    public Parent getRoot() {
        return feedbar;
    }

    public void loadCardFiltered(List<IssueFeedCard> list)
            throws IOException, InterruptedException {
        clearContainer();
        populateCards(list);
    }

    @FXML
    public void searchByKeyword() throws IOException,
            InterruptedException {
        String[] part = assembleString(search.getText()
                .toUpperCase());

        List<IssueFeedCard> list = orchestration.issueFilter()
                .getAllBySearch(
                        assembleFilter(part),
                        IssueFeedCard::new);
        loadCardFiltered(list);
    }

    private String[] assembleString(String target) {
        String[] partRaw = target
                .split("/", -1);
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
    public void handleShowIssueFiltered() {
        Filter filter = new Filter();
        addComponent(filter);
        filter.setCallback(listIssue -> {
            try {
                loadCardFiltered(listIssue);
            } catch (IOException |
                     InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
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
