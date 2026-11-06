package org.example.demo.view.dto.notice;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;

public class NotificationResponseDTO {
    @SerializedName("id")
    private Integer id;

    @SerializedName("testo")
    private String description;

    @SerializedName("data")
    private LocalDateTime date;

    @SerializedName("letta")
    private boolean isRead;

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public boolean isRead() {
        return isRead;
    }
}
