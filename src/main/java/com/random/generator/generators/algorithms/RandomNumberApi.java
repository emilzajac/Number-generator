package com.random.generator.generators.algorithms;

import com.random.generator.generators.GeneratorApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
public class RandomNumberApi extends GeneratorApi {

    @Value("${external.api.url.random-number-api-com}")
    private String apiRandomOrgUrl;

    @Override
    public List<Integer> generateIntegers(int min, int max, int howManyNumbers) {
        String response = getResponse(getHttpRequest("random?" + "min=" + min + "&" + "max=" + max + "&" + "count=" + howManyNumbers));
        return Stream.of(
                response.replace("[", "")
                        .replace("]", "")
                        .replace(" ", "")
                        .split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> generateUUIDs(int howManyUUIDs) {
        String response = getResponse(getHttpRequest("uuid?" + "count=" + howManyUUIDs));
        return Stream.of(
                response.replace("[\"", "")
                        .replace("\"]", "")
                        .replace(" \"", "")
                        .replace("\"", "")
                        .split(","))
                .collect(Collectors.toList());
    }

    private HttpRequest getHttpRequest(String operation) {
        return HttpRequest.newBuilder(URI.create(apiRandomOrgUrl + operation))
                .headers("Content-Type", "text/plain")
                .GET()
                .build();
    }

}
