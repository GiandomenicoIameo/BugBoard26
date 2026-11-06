package org.example.demo.view.components.bar;

import javafx.fxml.FXML;
import org.example.demo.view.core.Component;
import org.example.demo.view.core.Sequence;
import org.example.demo.view.core.Session;
import org.example.demo.view.core.orchestration.login.LoginOrchestration;
import org.example.demo.view.listeners.SidebarListener;
import org.example.demo.view.orchestrator.Orchestrator;
import org.example.demo.view.orchestrator.login.LoginOrchestrator;

public class Sidebar extends Component {
    protected SidebarListener listener;

    public void setListener(SidebarListener listener) {
        this.listener = listener;
    }

    @FXML
    protected void viewFeed() {
        if(listener != null)
            listener.viewFeed();
    }

    @FXML
    protected void signOut() {
        orchestration.login()
                .logout();
    }

    @FXML
    protected void viewSettings() {
        if(listener != null)
            listener.viewSettings();
    }
}
