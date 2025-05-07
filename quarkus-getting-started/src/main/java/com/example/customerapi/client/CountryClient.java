package com.example.customerapi.client;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.core.Response;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;

import java.io.StringReader;

@ApplicationScoped
public class CountryClient {

    public String getNationality(String countryCode) {
        try {
            Client client = ClientBuilder.newClient();
            Response response = client.target("https://restcountries.com/v3.1/alpha/" + countryCode)
                    .request(MediaType.APPLICATION_JSON).get();

            String body = response.readEntity(String.class);
            JsonArray array = Json.createReader(new StringReader(body)).readArray();
            JsonObject obj = array.getJsonObject(0);
            return obj.getJsonObject("demonyms").getJsonObject("eng").getString("m");
        } catch (Exception e) {
            return "Desconocido";
        }
    }
}
