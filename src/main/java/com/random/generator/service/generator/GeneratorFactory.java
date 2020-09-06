package com.random.generator.service.generator;

import com.random.generator.service.generator.algorithm.RandomOrgApi;
import com.random.generator.service.generator.algorithm.RandomNumberApi;

public class GeneratorFactory {

    private GeneratorFactory() {
        throw new UnsupportedOperationException();
    }

    public static GeneratorApi createRandomOrgApi() {
        return new RandomOrgApi();
    }

    public static GeneratorApi createRandomNumberApi() {
        return new RandomNumberApi();
    }

}
