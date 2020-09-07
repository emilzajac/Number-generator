package com.random.generator.service;

import com.random.generator.generators.GeneratorApi;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

class GeneratorServiceTest {

    @Mock
    GeneratorApi generatorApi;

    @InjectMocks
    GeneratorService generatorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void shouldReturnTreeGeneratedNumbersWhenParameterHowManyNumbersIsSetToThree() {
        // given
        when(generatorApi.generateIntegers(anyInt(), anyInt(), anyInt())).thenReturn(Arrays.asList(1, 2, 8));

        // when
        List<Integer> result = generatorService.generateIntegers(1, 10, 3);

        // then
        Assertions.assertThat(result.size()).isEqualTo(3);
    }

    @Test
    void shouldReturnTreeGeneratedUUIDWhenParameterHowManyNumbersIsSetToThree() {
        // given
        when(generatorApi.generateUUIDs(anyInt())).thenReturn(Arrays.asList("","",""));

        // when
        List<String> result = generatorService.generateUUIDs(3);

        // then
        Assertions.assertThat(result.size()).isEqualTo(3);
    }

}
