package org.example.demo.view.access.factory;

import org.example.demo.view.components.bar.regular.SidebarRegular;
import org.example.demo.view.session.Dock;
import org.example.demo.view.session.Regular;

public class RegularFactory implements DockFactory {
    @Override
    public void createDock() {
        Dock<SidebarRegular> dock = new Regular();
    }
}
