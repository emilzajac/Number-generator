package com.random.generator.service.generator;

import com.random.generator.exceptions.RandomGeneratorException;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Slf4j
public abstract class GeneratorApi implements GenerateIntegers, GenerateUUID {

    protected HttpClient httpClient = HttpClient.newBuilder().build();

    protected String getResponse(HttpRequest httpRequest) {
        HttpResponse<String> httpResponse;
        try {
            httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            return httpResponse.body();
        } catch (InterruptedException | IOException exception) {
            Thread.currentThread().interrupt();
            throw new RandomGeneratorException("GenerateIntegers error", exception);
        }
    }

}
