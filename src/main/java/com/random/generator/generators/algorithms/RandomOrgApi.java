package com.random.generator.generators.algorithms;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.random.generator.generators.GeneratorApi;
import lombok.Builder;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@Service
public class RandomOrgApi extends GeneratorApi {

    @Value("${external.api.url.random-org}")
    private String apiRandomOrgUrl;

    @Value("${external.api.key.random-org}")
    private String apiRandomOrgKey;

    @Override
    public List<Integer> generateIntegers(int min, int max, int howManyNumbers) {
        RequestBody requestBody = RequestBody.builder()
                .jsonrpc("2.0")
                .method("generateIntegers")
                .params(ParamsGenerateIntegers.builder()
                        .n(howManyNumbers)
                        .min(min)
                        .max(max)
                        .replacement(true)
                        .base(10)
                        .apiKey(apiRandomOrgKey)
                        .build())
                .id(getRandomId())
                .build();
        return extractIntValuesFromJSONArray(getResponse(getHttpRequest(getJsonBodyFromObject(requestBody))));
    }

    @Override
    public List<String> generateUUIDs(int howManyUUIDs) {
        RequestBody requestBody = RequestBody.builder()
                .jsonrpc("2.0")
                .method("generateUUIDs")
                .params(ParamsUUID.builder()
                        .n(howManyUUIDs)
                        .apiKey(apiRandomOrgKey)
                        .build())
                .id(getRandomId())
                .build();
        return extractStringValuesFromJSONArray(getResponse(getHttpRequest(getJsonBodyFromObject(requestBody))));
    }

    private HttpRequest getHttpRequest(String requestBody) {
        return HttpRequest.newBuilder(URI.create(apiRandomOrgUrl))
                .headers("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
    }

    private List<Integer> extractIntValuesFromJSONArray(String json) {
        List<Integer> numbers = new ArrayList<>();
        getAsJsonArray(json).iterator()
                .forEachRemaining(jsonElement -> numbers.add(jsonElement.getAsInt()));
        return numbers;
    }

    private List<String> extractStringValuesFromJSONArray(String json) {
        List<String> numbers = new ArrayList<>();
        getAsJsonArray(json).iterator()
                .forEachRemaining(jsonElement -> numbers.add(jsonElement.getAsString()));
        return numbers;
    }

    private JsonArray getAsJsonArray(String json) {
        return JsonParser.parseString(json)
                .getAsJsonObject()
                .get("result").getAsJsonObject()
                .get("random").getAsJsonObject()
                .get("data")
                .getAsJsonArray();
    }

    private String getJsonBodyFromObject(RequestBody requestBody) {
        Gson gson = new Gson();
        return gson.toJson(requestBody);
    }

    private int getRandomId() {
        Random random = new Random();
        return random.nextInt(100000);
    }

    @Builder
    public static class RequestBody {
        String jsonrpc;
        String method;
        Params params;
        int id;
    }

    @SuperBuilder
    public static class Params {
        String apiKey;
    }

    @SuperBuilder
    public static class ParamsUUID extends Params {
        int n;
    }

    @SuperBuilder
    public static class ParamsGenerateIntegers extends Params {
        int n;
        int min;
        int max;
        boolean replacement;
        int base;
    }

}
