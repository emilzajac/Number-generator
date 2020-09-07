package com.random.generator.service;

import com.random.generator.generators.GeneratorApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GeneratorService {

    private final GeneratorApi generatorApi;

    public List<Integer> generateIntegers(int min, int max, int howManyNumbers) {
        return generatorApi.generateIntegers(min, max, howManyNumbers);
    }

    public List<String> generateUUIDs(int howManyUUIDs) {
        return generatorApi.generateUUIDs(howManyUUIDs);
    }

}
