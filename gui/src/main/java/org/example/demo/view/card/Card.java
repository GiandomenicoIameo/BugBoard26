package org.example.demo.view.card;

import javafx.fxml.FXMLLoader;
import org.example.demo.view.Component;

public abstract class Card extends Component {

    protected Card(String path) {
        FXMLLoader loader = new FXMLLoader(getClass().
                getResource(path));

        loader.setController(this);

        try {
            loader.load();
        } catch (Exception e) {
            System.out.println("Ecco l'errore: ");
            e.printStackTrace();
        }
    }

    public static Card createIssueCard() {
        return new IssueCard();
    }

    public static Card createNewIssueCard() {
        return new NewIssueCard();
    }
}
