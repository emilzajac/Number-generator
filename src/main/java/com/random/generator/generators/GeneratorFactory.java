package com.random.generator.generators;

import com.random.generator.generators.algorithms.RandomNumberApi;
import com.random.generator.generators.algorithms.RandomOrgApi;

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
