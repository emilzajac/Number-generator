package com.random.generator.controllers;

import com.random.generator.service.RandomNumberService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/numbers")
public class RandomNumberController {

    private final RandomNumberService randomNumberService;

    @GetMapping
    public ResponseEntity<List<Integer>> getAll() {
        return ResponseEntity.ok(randomNumberService.findAll());
    }


}
