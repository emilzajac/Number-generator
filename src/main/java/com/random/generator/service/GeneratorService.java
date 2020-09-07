package com.random.generator.service;

import com.random.generator.generators.GeneratorApi;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneratorService {

    private GeneratorApi generatorApi;

    public GeneratorService(GeneratorApi generatorApi) {
        this.generatorApi = generatorApi;
    }

    public List<Integer> generateIntegers(int min, int max, int howManyNumbers) {
        return generatorApi.generateIntegers(min, max, howManyNumbers);
    }

    public List<String> generateUUIDs(int howManyUUIDs) {
        return generatorApi.generateUUIDs(howManyUUIDs);
    }

}
