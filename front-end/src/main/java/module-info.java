module org.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    requires com.google.gson;
    requires java.net.http;
    // 1. Apriamo i pacchetti per permettere di leggere i file .fxml e i @FXML
    opens org.example.demo.view.session to javafx.fxml;
    opens org.example.demo.view.components.card to javafx.fxml;

    // 2. Esportiamo a javafx.graphics tutti i pacchetti in cui hai una classe Main da poter avviare
    exports org.example.demo.view.session to javafx.graphics;
    exports org.example.demo.view.components.card to javafx.graphics;

    exports org.example.demo.view.core.contract;
    exports org.example.demo.view.core to javafx.graphics;
    exports org.example.demo.view.components.bar.admin to javafx.graphics;
    opens org.example.demo.view.components.bar.admin to javafx.fxml;
    exports org.example.demo.view.components.bar.regular to javafx.graphics;
    opens org.example.demo.view.components.bar.regular to javafx.fxml;
    exports org.example.demo.view.listeners to javafx.graphics;
    opens org.example.demo.view.listeners to javafx.fxml;
    exports org.example.demo.view.components.bar to javafx.graphics;
    opens org.example.demo.view.components.bar to javafx.fxml;
    exports org.example.demo.view.access.factory to javafx.graphics;
    opens org.example.demo.view.access.factory to javafx.fxml;
    exports org.example.demo.view.components.modal to javafx.graphics;
    opens org.example.demo.view.components.modal to javafx.fxml;
    exports org.example.demo.view.components.card.issue to javafx.graphics;
    exports org.example.demo.view.components.card.notice to javafx.graphics;
    opens org.example.demo.view.components.card.notice to javafx.fxml;
    exports org.example.demo.view.components.card.user to javafx.graphics;
    opens org.example.demo.view.components.card.user to javafx.fxml;
    exports org.example.demo.view.access to javafx.graphics;
    opens org.example.demo.view.access to javafx.fxml;
    opens org.example.demo.view.mapper.user to com.google.gson;
    opens org.example.demo.view.mapper.notice to com.google.gson;
    opens org.example.demo.view.mapper.issue to com.google.gson;
    exports org.example.demo.view.dto.user;
    opens org.example.demo.view.dto.user to com.google.gson;
    opens org.example.demo.view.dto.issue to com.google.gson;
    opens org.example.demo.view.dto.filter to com.google.gson;
    opens org.example.demo.view.dto.notice to com.google.gson;
    exports org.example.demo.view.dto.login;
    opens org.example.demo.view.dto.login to com.google.gson;
    opens org.example.demo.view.core to javafx.fxml;
    opens org.example.demo.view.components.card.issue to com.google.gson, javafx.fxml;
    exports org.example.demo.view.components.card.issue.definitions to javafx.graphics;
    opens org.example.demo.view.components.card.issue.definitions to com.google.gson, javafx.fxml;
    exports org.example.demo.view.components.card.issue.definitions.issueFeedCard to javafx.graphics;
    opens org.example.demo.view.components.card.issue.definitions.issueFeedCard to com.google.gson, javafx.fxml;
    exports org.example.demo.view.access.definitions to javafx.graphics;
    opens org.example.demo.view.access.definitions to javafx.fxml;
    exports org.example.demo.view.components.card.user.definitions to javafx.graphics;
    opens org.example.demo.view.components.card.user.definitions to javafx.fxml;
    exports org.example.demo.view.components.card.notice.definitions to javafx.graphics;
    opens org.example.demo.view.components.card.notice.definitions to javafx.fxml;
    exports org.example.demo.view.components.modal.definitions to javafx.graphics;
    opens org.example.demo.view.components.modal.definitions to javafx.fxml;
}