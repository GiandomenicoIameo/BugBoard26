package org.example.demo.view.dto.user;

import com.google.gson.annotations.SerializedName;

public class AdministratorDTO extends UserDTO {
    @SerializedName("")
    private String image;

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }
}
