package org.example.demo.view.components.bar.admin;

import javafx.fxml.FXML;
import org.example.demo.view.components.bar.Sidebar;
import org.example.demo.view.listeners.SidebarAdminListener;

public class SidebarAdmin extends Sidebar {
    private SidebarAdminListener adminListener;

    public SidebarAdmin() {
        show("sidebar.fxml");
    }

    public void setAdminListener(SidebarAdminListener listener) {
        super.setListener(listener);
        this.adminListener = listener;
    }

    @FXML
    public void viewGroup() {
        if(adminListener != null)
            adminListener.viewGroup();
    }
}
