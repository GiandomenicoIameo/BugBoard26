package org.example.demo.view.components.bar.admin;

import javafx.fxml.FXML;
import org.example.demo.view.components.bar.Sidebar;
import org.example.demo.view.listeners.SidebarAdminListener;

public class SidebarAdmin extends Sidebar<SidebarAdminListener> {
    public SidebarAdmin() {
        show("sidebar.fxml");
    }

    @FXML
    public void viewGroup() {
        if(listener != null)
            listener.viewGroup();
    }
}
