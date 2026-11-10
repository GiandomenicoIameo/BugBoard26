package org.example.demo.view.components.bar.regular;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import org.example.demo.view.components.bar.Sidebar;
import org.example.demo.view.components.modal.Modal;
import org.example.demo.view.components.modal.NoticeModal;
import org.example.demo.view.listeners.SidebarRegularListener;

import java.io.IOException;

public class SidebarRegular extends Sidebar<SidebarRegularListener> {
    @FXML private AnchorPane menubar;

    public SidebarRegular() {
        show("sidebar.fxml");
    }

    @FXML
    public void viewAssignments() throws IOException,
            InterruptedException {
        if(listener != null)
            listener.viewAssignments();
    }

    @FXML
    public void viewNotice() {
        Modal.show(new NoticeModal()
                .getRoot(), menubar);
    }
}
