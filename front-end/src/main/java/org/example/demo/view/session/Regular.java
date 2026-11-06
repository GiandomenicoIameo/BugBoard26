package org.example.demo.view.session;

import org.example.demo.view.components.bar.regular.SettingsbarRegular;
import org.example.demo.view.components.bar.regular.Assignmentbar;
import org.example.demo.view.components.bar.regular.SidebarRegular;
import org.example.demo.view.listeners.SidebarRegularListener;

public class Regular extends Dock<SidebarRegular>
        implements SidebarRegularListener {
    private final Assignmentbar assignmentbar =
            new Assignmentbar();

    public Regular() {
        super();
        sidebar = new SidebarRegular();
        settingsbar = new
                SettingsbarRegular();

        show("regular.fxml");
    }

    protected void setListeners() {
        sidebar.setRegularListener(this);
    }

    protected void config() {
        super.config();
        // Le istruzioni addComponent() sono opzionali, in quanto vengono
        // utilizzate solo per mantenere la relazione di composizione.
        add(sidebar,
                sidebarContainer);
        add(feedbar,
                dockContainer);
        add(settingsbar,
                dockContainer);
        add(assignmentbar,
                dockContainer);

        addComponent(assignmentbar);
        addComponent(sidebar);
        addComponent(feedbar);
        addComponent(settingsbar);
    }

    @Override
    public void viewAssignments() {
        current(assignmentbar);
    }
}
