package org.example.demo.view.dto.issue;

import com.google.gson.annotations.SerializedName;

// Classe DTO in uscita
public class IssueRequestDTO {
    @SerializedName("titolo")
    private String title;

    @SerializedName("descrizione")
    private String description;

    @SerializedName("immagine")
    private String image;

    @SerializedName("tipo")
    private String typology;

    @SerializedName("priorita")
    private String priority;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setTypology(String typology) {
        this.typology = typology;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
