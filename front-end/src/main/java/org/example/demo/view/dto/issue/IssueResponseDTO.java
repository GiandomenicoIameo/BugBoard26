package org.example.demo.view.dto.issue;

import com.google.gson.annotations.SerializedName;
import org.example.demo.view.dto.user.PrompterUserResponseDTO;
import org.example.demo.view.dto.user.UserDTO;

import java.time.LocalDateTime;

public class IssueCardResponseDTO {
    @SerializedName("id")
    private int id;

    @SerializedName("titolo")
    private String title;

    @SerializedName("descrizione")
    private String description;

    @SerializedName("data")
    private LocalDateTime date;

    @SerializedName("stato")
    private String state;

    @SerializedName("priorita")
    private String priority;

    @SerializedName("tipo")
    private String typology;

    @SerializedName("utenteCreatore")
    private UserDTO creator;

    @SerializedName("assegnatario")
    private PrompterUserResponseDTO assignee;

    @SerializedName("duplicato")
    private Boolean duplicated;

    public void setTypology(String typology) {
        this.typology = typology;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getState() {
        return state;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getPriority() {
        return priority;
    }

    public String getTypology() {
        return typology;
    }

    public UserDTO getCreator() {
        return creator;
    }

    public PrompterUserResponseDTO getAssignee() {
        return assignee;
    }

    public Boolean getDuplicated() {
        return duplicated;
    }

    public String getCreatorName() {
        if(creator != null)
            return creator.getName();
        return null;
    }
}
