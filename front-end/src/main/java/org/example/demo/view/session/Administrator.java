package org.example.demo.view.session;

import org.example.demo.view.components.bar.Feedbar;
import org.example.demo.view.components.bar.admin.*;
import org.example.demo.view.listeners.SidebarAdminListener;

public class Administrator extends Dock
        implements SidebarAdminListener {

    public Administrator() {
        super();

        addComponent(new SidebarAdmin());
        addComponent(new SettingsbarAdmin());
        addComponent(new Groupbar());

        show("administrator.fxml");

        toDock(getComponent(
                SidebarAdmin.class),
                sidebarContainer);
        toDock(getComponent(
                Feedbar.class),
                dockContainer);
        toDock(getComponent(
                SettingsbarAdmin.class),
                dockContainer);
        toDock(getComponent(
                Groupbar.class),
                dockContainer);
    }

    @Override
    public void viewGroup() {
        current(getComponent(
                Groupbar.class));
    }
}
