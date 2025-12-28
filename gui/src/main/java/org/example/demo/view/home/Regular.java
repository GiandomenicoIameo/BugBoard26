package org.example.demo.view.home;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import org.example.demo.view.Component;
import org.example.demo.view.card.NewIssueCard;

class Regular extends Homepage {

    @FXML
    private VBox cardCreateContainer;

    Regular() {
        super("regular-homepage.fxml");
    }

    @Override
    protected void listComponents() {
        super.listComponents();

        for(Component component : components.keySet()) {
            if(component.getInstance() instanceof NewIssueCard)
                cardCreateContainer.getChildren().
                        add(component.getRoot());
        }
    }
}
