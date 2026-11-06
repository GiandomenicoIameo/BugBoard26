package org.example.demo.view.access.factory;

import org.example.demo.view.session.Regular;

public class RegularFactory implements DockFactory {
    @Override
    public void createDock() {
        new Regular();
    }
}
