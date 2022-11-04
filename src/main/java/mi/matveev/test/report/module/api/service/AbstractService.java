package mi.matveev.test.report.module.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mi.matveev.test.report.module.api.enumeration.ApiPath;
import mi.matveev.test.report.module.config.ReportConfig;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public abstract class AbstractService {
    private final static ObjectMapper mapper = new ObjectMapper();
    private final static HttpClient httpClient = HttpClient.newHttpClient();

    protected static String post(ApiPath path, Object body) {
        try {
            HttpRequest.BodyPublisher requestBody = requestBody = HttpRequest.BodyPublishers
                    .ofString(mapper.writeValueAsString(body));
            HttpRequest request = getRequestBuilder(path)
                    .POST(requestBody)
                    .build();

            return send(request);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private static String send(HttpRequest request) {
        try {
            return httpClient.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static HttpRequest.Builder getRequestBuilder(ApiPath path) {
        return HttpRequest.newBuilder()
                .uri(URI.create(ReportConfig.url() + path.path))
                .header("Content-Type", "application/json");
    }
}
