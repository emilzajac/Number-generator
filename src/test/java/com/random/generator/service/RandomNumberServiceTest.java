package com.random.generator.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource(properties = "resources/application-test.properties")
class RandomNumberServiceTest {

    @Autowired
    RandomNumberService randomNumberService;

    @Test
    void shouldReturnAllNumbersFromDatabase() {
        // when
        List<Integer> result = randomNumberService.findAll();

        // then
        Assertions.assertThat(result).hasSize(12);
    }
}
