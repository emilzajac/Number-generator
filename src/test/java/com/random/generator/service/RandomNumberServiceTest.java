package com.random.generator.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource(properties = "liquibase.change-log=classpath:db.changelog/db.changelog-master-test.xml")
class RandomNumberServiceTest {

    @Autowired
    RandomNumberService randomNumberService;

    @Test
    void shouldReturnAllNumbersFromDatabase() {
        // when
        List<Integer> result = randomNumberService.findAll();

        // then
        Assertions.assertThat(result).hasSize(13);
    }
}
