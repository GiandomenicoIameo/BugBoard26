package org.example.demo.view.components.modal.definitions;

public interface FilterView {
    String getKeyword();
    String getPriority();
    String getTypology();
    String getState();

    void setKeyword(String keyword);
    void setPriority(String priority);
    void setTypology(String typology);
    void setState(String state);
}
