package org.example.demo.view.dto.login;

import com.google.gson.annotations.SerializedName;

public class LoginResponseDTO {
    @SerializedName("id")
    private int id;

    @SerializedName("nome")
    private String name;

    @SerializedName("cognome")
    private String surname;

    @SerializedName("email")
    private String email;

    @SerializedName("ruolo")
    private String role;

    // Non sono necessari i metodi set, dal momento che il metodo gson.fromJson()
    // usa la riflessione per accedere ai campi di quest'oggetto e inserire i valori.
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }
}
