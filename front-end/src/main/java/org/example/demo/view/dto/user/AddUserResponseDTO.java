package org.example.demo.view.dto.user;

import com.google.gson.annotations.SerializedName;

public class AddUserResponseDTO {
    @SerializedName("nome")
    public String name;

    @SerializedName("cognome")
    public String surname;

    @SerializedName("email")
    public String email;

    @SerializedName("ruolo")
    public String role;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }
}
