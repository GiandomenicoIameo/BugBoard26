module org.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens org.example.demo.view.home to javafx.fxml;
    exports org.example.demo.view.home;

    opens org.example.demo.view.access to javafx.fxml;
    exports org.example.demo.view.access;
    exports org.example.demo.view.card;
    opens org.example.demo.view.card to javafx.fxml;
    exports org.example.demo.view;
}