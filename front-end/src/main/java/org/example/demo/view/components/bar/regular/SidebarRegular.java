package org.example.demo.view.components.bar.regular;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import org.example.demo.view.components.bar.Sidebar;
import org.example.demo.view.components.modal.Modal;
import org.example.demo.view.components.modal.Notification;
import org.example.demo.view.core.Sequence;
import org.example.demo.view.listeners.SidebarRegularListener;

import java.io.IOException;

public class SidebarRegular extends Sidebar {
    private SidebarRegularListener regularListener;

    @FXML private AnchorPane menubar;

    public SidebarRegular() {
        show("sidebar.fxml");
    }

    @FXML
    public void initialize() {
        configureMaximize(menubar, Sequence
                .getCurrStage());
    }

    public void setRegularListener(SidebarRegularListener listener) {
        super.setListener(listener);
        this.regularListener = listener;
    }

    @FXML
    public void viewAssignments() throws IOException,
            InterruptedException {
        if(regularListener != null)
            regularListener.viewAssignments();
    }

    @FXML
    public void viewNotice() {
        Notification notification = new
                Notification();
        Modal.show(notification.getRoot(),
                menubar);
    }
}
