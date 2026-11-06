package org.example.demo.view.access.factory;

import org.example.demo.view.session.Administrator;

public class AdministratorFactory implements DockFactory {
    @Override
    public void createDock() {
        new Administrator();
    }
}
