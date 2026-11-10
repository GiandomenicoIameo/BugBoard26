package org.example.demo.view.service.login;

import com.google.gson.Gson;
import org.example.demo.view.dto.login.LoginRequestDTO;
import org.example.demo.view.dto.login.LoginResponseDTO;

import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LoginService {
    private Gson gson = new Gson();
    private static final String path = "http://localhost:8080";
    private static final HttpClient client = HttpClient.newBuilder()
            .cookieHandler(new CookieManager(null, CookiePolicy.ACCEPT_ALL))
            .build();

    public static HttpClient getClient() {
        return client;
    }

    private HttpRequest request(String uri, String json) {
        return HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type",
                        "application/json")
                .POST(HttpRequest
                        .BodyPublishers
                        .ofString(json))
                .build();
    }

    private HttpResponse<String> response(HttpRequest request) throws IOException,
            InterruptedException {
        return client.send(request, HttpResponse
                .BodyHandlers.ofString());
    }

    public LoginResponseDTO toLogin(LoginRequestDTO loginDTO) throws IOException, InterruptedException {
        String json = gson.toJson(loginDTO);

        HttpRequest request = request(path + "/api/auth/login", json);
        HttpResponse<String> response = response(request);

        System.out.println("Intestazioni Set-Cookie ricevute: " + response.headers().allValues("Set-Cookie"));

        System.out.println("Risposta dal server: " + response.body());

        if (response.statusCode() == 200 || response.statusCode() == 201)
            return gson.fromJson(response.body(),
                    LoginResponseDTO.class);
        else
            throw new RuntimeException("Errore. Codice: " +
                    response.statusCode());
    }
}
