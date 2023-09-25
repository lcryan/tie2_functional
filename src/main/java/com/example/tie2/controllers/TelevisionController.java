package com.example.tie2.controllers;

import com.example.tie2.dtos.TelevisionDto;
import com.example.tie2.dtos.TelevisionInputDto;
import com.example.tie2.services.TelevisionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TelevisionController {

    private final TelevisionService televisionService;

    public TelevisionController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }

    @GetMapping("/televisions")
    public ResponseEntity<List<TelevisionDto>> getAllTelevisions() {
        return ResponseEntity.ok(televisionService.getAllTelevisions());
    }

    @PostMapping("/televisions")
    public ResponseEntity<TelevisionDto> createTelevision(@Valid @RequestBody TelevisionInputDto televisionInputDto) {
        TelevisionDto televisionDto = televisionService.createTelevision(televisionInputDto);
        return ResponseEntity.created(null).body(televisionDto);
    }

    @GetMapping("/televisions/{id}")
    public ResponseEntity<TelevisionDto> getTelevision(@PathVariable Long id) {
        return ResponseEntity.ok(televisionService.getOneTelevision(id));
    }

    @DeleteMapping("/televisions/{id}")
    public ResponseEntity<Optional<TelevisionDto>> deleteOneTelevision(@PathVariable Long id) {
        televisionService.deleteTelevision(id); // calling on function in service //
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/televisions/{id}")

    public ResponseEntity<TelevisionDto> updateTelevision(@PathVariable Long id, @Valid @RequestBody TelevisionInputDto televisionInputDto) {
        TelevisionDto televisionInputDto1 = televisionService.updateTelevision(id, televisionInputDto);
        return ResponseEntity.ok().body(televisionInputDto1);
    }
}




