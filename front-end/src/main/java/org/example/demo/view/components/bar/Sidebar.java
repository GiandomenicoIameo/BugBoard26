package org.example.demo.view.components.bar;

import javafx.fxml.FXML;
import org.example.demo.view.core.Component;
import org.example.demo.view.listeners.SidebarListener;

public abstract class Sidebar<T extends SidebarListener> extends Component {
    protected T listener;

    public void setListener(T listener) {
        this.listener = listener;
    }

    @FXML
    public void viewFeed() {
        if(listener != null)
            listener.viewFeed();
    }

    @FXML
    protected void signOut() {
        if(listener != null)
            listener.signOut();
    }

    @FXML
    protected void viewSettings() {
        if(listener != null)
            listener.viewSettings();
    }
}
