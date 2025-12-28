package org.example.demo.view.home;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import org.example.demo.view.Component;
import org.example.demo.view.View;
import org.example.demo.view.card.IssueCard;
import java.io.IOException;

public abstract class Homepage extends View {

    @FXML
    private VBox cardContainer;

    protected Homepage(String path) {
        FXMLLoader loader = new FXMLLoader(getClass().
                getResource(path));

        loader.setController(this);

        try {
            view = loader.load();
        } catch (IOException e) {
            throw new RuntimeException("Impossibile " +
                    "caricare la vista", e);
        }
    }

    // Qui ho utilizzato il pattern Factory.
    public static Homepage createRegular() {
        return new Regular();
    }

    public static Homepage createAdministrator() {
        return new Administrator();
    }

    @FXML
    protected void signOut(ActionEvent e) {
        System.exit(0);
    }

    @Override
    protected void listComponents() {
       // Collection<Node> nodes = components.values();

        for(Component component : components.keySet()) {
            if(component.getInstance() instanceof IssueCard)
                cardContainer.getChildren().
                        add(component.getRoot());
        }
        //cardContainer.getChildren().clear();
        //cardCreateContainer.getChildren().addAll(nodes);
    }

    // Il seguente metodo deve essere utilizzato solo per
    // mostrare l'interfaccia grafica di Homepage quando viene
    // invocata nel main di Homepage. Alla fine deve essere eliminato.
    @Override
    protected Parent show() {
        return super.show();
    }
}