package org.example.demo.view.service.user;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.demo.view.dto.user.AddUserRequestDTO;
import org.example.demo.view.dto.user.AddUserResponseDTO;
import org.example.demo.view.dto.user.RegularDTO;
import org.example.demo.view.dto.user.UserDTO;
import org.example.demo.view.service.login.Authentication;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class UserService {
    private Gson gson = new Gson();
    private static final String path = "http://localhost:8080";
    private static final HttpClient client = Authentication.getClient();

    private HttpRequest requestPost(String uri, String json) {
        return HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type",
                        "application/json")
                .POST(HttpRequest
                        .BodyPublishers
                        .ofString(json))
                .build();
    }

    private HttpRequest requestGet(String uri) {
        return HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();
    }

    private HttpResponse<String> response(HttpRequest request) throws IOException,
            InterruptedException {
        return client.send(request, HttpResponse
                .BodyHandlers.ofString());
    }

    public AddUserResponseDTO createUser(AddUserRequestDTO userDTO) throws IOException,
            InterruptedException {
        String json = gson.toJson(userDTO);

        HttpRequest request = requestPost(path + "/api/utenti", json);
        HttpResponse<String> response = response(request);

        if (response.statusCode() == 200 || response.statusCode() == 201)
            return gson.fromJson(response.body(),
                    AddUserResponseDTO.class);
        else
            throw new RuntimeException("Errore. Codice: " +
                    response.statusCode());
    }

    public List<AddUserResponseDTO> listUsers() throws IOException, InterruptedException {
        HttpRequest request = requestGet(path + "/api/utenti");
        HttpResponse<String> response = response(request);

        if (response.statusCode() == 200 || response.statusCode() == 201) {
            Type listType = new TypeToken<List<AddUserResponseDTO>>() {}
            .getType();
            return gson.fromJson(response.body(), listType);
        }
        else
            throw new RuntimeException("Errore. Codice: " +
                    response.statusCode());
    }

    public List<RegularDTO> suggested() throws IOException,
            InterruptedException {
        HttpRequest request = requestGet(path + "/api/utenti/suggeriti");
        HttpResponse<String> response = response(request);

        System.out.println("Risposta dal server: " + response.body());

        if (response.statusCode() == 200 || response.statusCode() == 201) {
            Type listType = new TypeToken<List<RegularDTO>>() {}
                    .getType();
            return gson.fromJson(response.body(), listType);
        }
        else
            throw new RuntimeException("Errore. Codice: " +
                    response.statusCode());
    }

    public UserDTO me() throws IOException,
            InterruptedException {
        HttpRequest request = requestGet(path + "/api/auth/me");
        HttpResponse<String> response = response(request);

        System.out.println("Risposta dal server: " + response.body());

        if (response.statusCode() == 200 || response.statusCode() == 201)
            return gson.fromJson(response.body(),
                    UserDTO.class);
        else
            throw new RuntimeException("Errore. Codice: " +
                    response.statusCode());
    }
}
