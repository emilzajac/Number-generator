package com.random.generator.generators;

import com.random.generator.generators.algorithms.AlgorithmEnum;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class GeneratorConfig {

    @Value("${selected.external.api}")
    private String selectedExternalApi;

    @Bean
    @Primary
    public GeneratorApi createGenerator() {
        switch (AlgorithmEnum.valueOf(selectedExternalApi)) {
            case API_RANDOM_ORG:
                return GeneratorFactory.createRandomOrgApi();
            case RANDOM_NUMBER_API:
                return GeneratorFactory.createRandomNumberApi();
            default:
                throw new NoSuchBeanDefinitionException(String.format("No found generator for: %s", selectedExternalApi));
        }
    }

}
