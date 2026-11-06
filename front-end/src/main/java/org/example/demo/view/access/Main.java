package org.example.demo.view.access;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.demo.view.access.factory.AdministratorFactory;
import org.example.demo.view.access.factory.DockFactory;
import org.example.demo.view.access.factory.RegularFactory;
import org.example.demo.view.core.Sequence;
import org.example.demo.view.core.contract.Role;

import java.util.HashMap;
import java.util.Map;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        Map<Role, DockFactory> map = new HashMap<>();

        // Registrazione degli utenti.
        map.put(Role.AMMINISTRATORE,
                new AdministratorFactory());
        map.put(Role.NORMALE,
                new RegularFactory());

        Sequence.setCurrStage(stage);
        Login access = new Login(map);
    }

    public static void main(String[] args) {
        launch();
    }
}