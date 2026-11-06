package org.example.demo.view.access.factory;

import org.example.demo.view.components.bar.admin.SidebarAdmin;
import org.example.demo.view.session.Dock;
import org.example.demo.view.session.Administrator;

public class AdministratorFactory implements DockFactory {
    @Override
    public void createDock() {
        Dock<SidebarAdmin> dock = new Administrator();
    }
}
