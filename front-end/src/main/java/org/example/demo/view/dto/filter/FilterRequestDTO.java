package org.example.demo.view.dto.filter;

public class FilterRequestDTO {
    private String keyword;
    private String priority;
    private String state;
    private String typology;

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setTypology(String typology) {
        this.typology = typology;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getPriority() {
        return priority;
    }

    public String getTypology() {
        return  typology;
    }

    public String getState() {
        return state;
    }
}
