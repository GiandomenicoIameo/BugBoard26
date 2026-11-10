package org.example.demo.view.session;

import org.example.demo.view.components.bar.Feedbar;
import org.example.demo.view.components.bar.regular.SettingsbarRegular;
import org.example.demo.view.components.bar.regular.Assignmentbar;
import org.example.demo.view.components.bar.regular.SidebarRegular;
import org.example.demo.view.listeners.SidebarRegularListener;

public class Regular extends Dock
        implements SidebarRegularListener {

    public Regular() {
        super();

        addComponent(new SidebarRegular());
        addComponent(new SettingsbarRegular());
        addComponent(new Assignmentbar());

        show("regular.fxml");

        toDock(getComponent(
                SidebarRegular.class),
                sidebarContainer);
        toDock(getComponent(
                Feedbar.class),
                dockContainer);
        toDock(getComponent(
                SettingsbarRegular.class),
                dockContainer);
        toDock(getComponent(
                Assignmentbar.class),
                dockContainer);
    }

    @Override
    public void viewAssignments() {
        current(getComponent(
                Assignmentbar.class));
    }
}
