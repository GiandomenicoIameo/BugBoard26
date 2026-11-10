package org.example.demo.view.dto.user;

import com.google.gson.annotations.SerializedName;

public class AddUserRequestDTO {
    @SerializedName("nome")
    public String name;

    @SerializedName("cognome")
    public String surname;

    @SerializedName("email")
    public String email;

    @SerializedName("password")
    public String password;

    @SerializedName("ruolo")
    public String role;

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }
}
