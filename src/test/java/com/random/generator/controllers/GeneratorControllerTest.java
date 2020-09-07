package com.random.generator.controllers;

import com.random.generator.service.GeneratorService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

class GeneratorControllerTest {

    @Mock
    GeneratorService generatorService;

    @InjectMocks
    GeneratorController generatorController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void shouldReturnStatus200WhenRandomIntegersWasGenerated() {
        // given
        when(generatorService.generateIntegers(anyInt(), anyInt(), anyInt())).thenReturn(Collections.singletonList(1));

        // when
        ResponseEntity<List<Integer>> result = generatorController.generateIntegers(anyInt(), anyInt(), anyInt());

        // then
        Assertions.assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void shouldReturnStatus200WhenRandomUUIDsWasGenerated() {
        // given
        when(generatorService.generateUUIDs(anyInt())).thenReturn(Collections.singletonList(""));

        // when
        ResponseEntity<List<String>> result = generatorController.generateUUIDs(anyInt());

        // then
        Assertions.assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}
