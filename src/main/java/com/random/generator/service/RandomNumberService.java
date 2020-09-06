package com.random.generator.service;

import com.random.generator.model.RandomNumber;
import com.random.generator.repository.RandomNumberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RandomNumberService {

    private final RandomNumberRepository randomNumberRepository;

    public List<Integer> findAll() {
        return randomNumberRepository.findAll().stream()
                .map(RandomNumber::getNumber)
                .collect(Collectors.toList());
    }

}
