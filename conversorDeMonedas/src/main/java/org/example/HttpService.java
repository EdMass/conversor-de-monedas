package org.example;

import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpService {
    private final HttpClient httpClient;
    private final String baseUrl;
    private final String apiKey;

    public HttpService() {
        this.httpClient = HttpClient.newHttpClient();
        Dotenv dotenv = Dotenv.load(); // Carga el archivo .env
        this.baseUrl = dotenv.get("EXCHANGE_URL"); // Obtiene la url
        this.apiKey = dotenv.get("API_KEY"); // obtiene la api key
    }

    public String fetchExchangeRate(String fromCurrency, String toCurrency) throws IOException, InterruptedException {
        String apiUrl = String.format("%s/%s/pair/%s/%s", baseUrl,apiKey, fromCurrency, toCurrency);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }


}
