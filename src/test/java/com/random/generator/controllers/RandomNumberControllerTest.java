package com.random.generator.controllers;

import com.random.generator.service.RandomNumberService;
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

import static org.mockito.Mockito.when;

class RandomNumberControllerTest {

    @Mock
    RandomNumberService randomNumberService;

    @InjectMocks
    RandomNumberController randomNumberController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void shouldReturnStatus200WhenRandomNumbersWasFound() {
        // given
        when(randomNumberService.findAll()).thenReturn(Collections.singletonList(1));

        // when
        ResponseEntity<List<Integer>> result = randomNumberController.getAll();

        // then
        Assertions.assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
