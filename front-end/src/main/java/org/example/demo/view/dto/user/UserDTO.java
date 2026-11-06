package org.example.demo.view.dto.user;

import com.google.gson.annotations.SerializedName;

public class UserDTO {
    @SerializedName("id")
    private int id;

    @SerializedName("nome")
    private String name;

    @SerializedName("email")
    private String email;

    @SerializedName("ruolo")
    protected String role;

    private void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
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
