package org.example.demo.view.dto.user;

import com.google.gson.annotations.SerializedName;

public class RegularDTO extends UserDTO {
    @SerializedName("cognome")
    private String surname;

    public String getSurname() {
        return surname;
    }
}
