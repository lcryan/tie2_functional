package com.example.tie2.controllers;

import com.example.tie2.exceptions.TelevisionNotFoundException;
import com.example.tie2.repositories.TelevisionRepository;
import com.example.tie2.models.Television;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    @Autowired
    private TelevisionRepository televisionRepository;

    @GetMapping
    public ResponseEntity<List<Television>> getTelevision() {
        return ResponseEntity.ok(televisionRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Television> createOneTelevision(@RequestBody Television television) {
        televisionRepository.save(television);
        URI uri = URI.create(ServletUriComponentsBuilder.
                fromCurrentRequest().
                path("/" + television.getId()).toUriString());
    }
}






