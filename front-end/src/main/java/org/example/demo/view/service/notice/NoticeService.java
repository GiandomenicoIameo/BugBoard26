package org.example.demo.view.service.notice;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.example.demo.view.dto.notice.NotificationResponseDTO;
import org.example.demo.view.service.login.Authentication;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class NoticeService {
    Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
            .create();
    private static final String path = "http://localhost:8080";
    private final HttpClient client =  Authentication.getClient();

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

    private HttpRequest requestPost(String uri) {
        return HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Accept", "application/json")
                .POST(HttpRequest.BodyPublishers.noBody())
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

    public List<NotificationResponseDTO> listNotice() throws IOException,
            InterruptedException {
        HttpRequest request = requestGet(path + "/api/notifiche");
        HttpResponse<String> response = response(request);

        System.out.println("Risposta dal server: " + response.body());

        if (response.statusCode() == 200 || response.statusCode() == 201) {
            Type listType = new TypeToken<List<NotificationResponseDTO>>() {}
                    .getType();
            return gson.fromJson(response.body(), listType);
        }
        else
            throw new RuntimeException("Errore. Codice: " +
                    response.statusCode());
    }

    public List<NotificationResponseDTO> listNoticeRead() throws IOException,
            InterruptedException {
        HttpRequest request = requestPost(path + "/api/notifiche/leggi-nuove");
        HttpResponse<String> response = response(request);

        System.out.println("Risposta dal server: " + response.body());

        if (response.statusCode() == 200 || response.statusCode() == 201) {
            Type listType = new TypeToken<List<NotificationResponseDTO>>() {}
                    .getType();
            return gson.fromJson(response.body(), listType);
        }
        else
            throw new RuntimeException("Errore. Codice: " +
                    response.statusCode());
    }

    private class LocalDateTimeAdapter implements JsonSerializer<LocalDateTime>,
            JsonDeserializer<LocalDateTime> {
        private static final DateTimeFormatter formatter = DateTimeFormatter
                .ISO_LOCAL_DATE_TIME;

        @Override
        public JsonElement serialize(LocalDateTime src,
                                     Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(formatter
                    .format(src));
        }

        @Override
        public LocalDateTime deserialize(JsonElement json,
                                         Type typeOfT, JsonDeserializationContext context)
                throws JsonParseException {
            return LocalDateTime.parse(json
                    .getAsString(), formatter);
        }
    }
}
