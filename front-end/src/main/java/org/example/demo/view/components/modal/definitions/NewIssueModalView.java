package org.example.demo.view.components.modal.definitions;

import java.io.IOException;

public interface NewIssueModalView {
    String getTitle();
    String getDescription();
    String getTypology();
    String getPriority();
    String getImage() throws IOException;
}
