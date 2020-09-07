package com.random.generator.controllers;

import com.random.generator.service.GeneratorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/generate")
public class GeneratorController {

    private final GeneratorService generatorService;

    @GetMapping("/numbers")
    public ResponseEntity<List<Integer>> generateIntegers(@RequestParam int min,
                                                          @RequestParam int max,
                                                          @RequestParam int howManyNumbers) {
        return ResponseEntity.ok(generatorService.generateIntegers(min, max, howManyNumbers));
    }

    @GetMapping("/uuids")
    public ResponseEntity<List<String>> generateUUIDs(@RequestParam int howManyNumbers) {
        return ResponseEntity.ok(generatorService.generateUUIDs(howManyNumbers));
    }

}
