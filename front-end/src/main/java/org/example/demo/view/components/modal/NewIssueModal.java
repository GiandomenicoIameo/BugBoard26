package org.example.demo.view.components.modal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.example.demo.view.components.card.Card;
import org.example.demo.view.components.card.issue.IssueFeedCard;
import org.example.demo.view.components.modal.definitions.NewIssueCardView;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.function.Consumer;

public class NewIssueCard extends Card implements NewIssueCardView {
    private File file;
    private Consumer<IssueFeedCard> callback;

    @FXML private VBox root;

    @FXML private TextField title;
    @FXML private TextArea description;
    @FXML private TextField image;

    @FXML private TextField typology;
    @FXML private TextField priority;


    public NewIssueCard() {
        show("create-issue.fxml");
    }

    public void setCallback(Consumer<IssueFeedCard> callback) {
        this.callback = callback;
    }

    public String getTitle() {
        return title.getText();
    }

    public String getDescription() {
        return description.getText();
    }

    public String getTypology() {
        return typology.getText();
    }

    public String getPriority() {
        return priority.getText();
    }

    public String getImage() throws IOException {
        byte[] bytes = Files.
                readAllBytes(file.toPath());
        return Base64.getEncoder()
                .encodeToString(bytes);
    }

    @Override
    public Parent getRoot() {
        return root;
    }

    @FXML
    public void handleAdd() throws IOException,
            InterruptedException {
        IssueFeedCard card = orchestration
                .issueFeed()
                .create(this, new IssueFeedCard());

        if (callback != null)
            callback.accept(card);
        close();
    }

    @FXML
    public void onMenuTypologySelected(ActionEvent event) {
        MenuItem voce = (MenuItem) event
                .getSource();
        typology.setText(voce.getText());
    }

    @FXML
    public void onMenuPrioritySelected(ActionEvent event) {
        MenuItem voce = (MenuItem) event
                .getSource();
        priority.setText(voce.getText());
    }

    @FXML
    public void close() {
        Stage stage = (Stage) root
                .getScene().getWindow();
        stage.close();
    }

    @FXML
    public void addImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleziona un'immagine");

        // Filtro per far selezionare SOLO immagini
        // (evita che l'utente carichi PDF o documenti)
        FileChooser.ExtensionFilter extFilter = new FileChooser
                .ExtensionFilter(
                "File Immagine (*.png, *.jpg, *.jpeg)",
                "*.png", "*.jpg", "*.jpeg"
        );
        fileChooser.getExtensionFilters()
                .add(extFilter);
        // Recuperiamo la finestra (Stage) corrente
        // per dirgli dove aprire il popup
        // Usiamo imageViewFoto per risalire alla
        // scena e poi alla finestra
        Stage stageCorrente = (Stage) image
                .getScene().getWindow();
        // 4. Mostriamo la finestra e aspettiamo
        // che l'utente scelga il file
        file = fileChooser
                .showOpenDialog(stageCorrente);

        if (file != null) {
            String path = file.getName();
            image.setText(path);
        }
    }
}
