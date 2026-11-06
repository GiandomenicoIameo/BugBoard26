package org.example.demo.view.session;

import org.example.demo.view.components.bar.admin.*;
import org.example.demo.view.listeners.SidebarAdminListener;

public class Administrator extends Dock<SidebarAdmin>
        implements SidebarAdminListener {
    private final Groupbar groupbar
            = new Groupbar();

    public Administrator() {
        super();
        sidebar = new SidebarAdmin();
        settingsbar = new
                SettingsbarAdmin();

        show("administrator.fxml");
    }

    protected void setListeners() {
        sidebar.setAdminListener(this);
    }

    protected void config() {
        super.config();
        // Le seguenti istruzioni sono opzionali, in quanto vengono
        // utilizzate solo per mantenere la relazione di composizione.
        add(
                sidebar,
                sidebarContainer);
        add(
                feedbar,
                dockContainer);
        add(
                settingsbar,
                dockContainer);
        add(
                groupbar,
                dockContainer);

        addComponent(groupbar);
        addComponent(sidebar);
        addComponent(feedbar);
        addComponent(settingsbar);
    }

    @Override
    public void viewGroup() {
        current(groupbar);
    }
}
