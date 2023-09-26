package com.example.tie2.controllers;

import com.example.tie2.dtos.WallBracketDto;
import com.example.tie2.dtos.WallBracketInputDto;
import com.example.tie2.services.WallBracketService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

@RestController
public class WallBracketController {

    private final WallBracketService wallBracketService;

    public WallBracketController(WallBracketService wallBracketService) {
        this.wallBracketService = wallBracketService;
    }

    @GetMapping("/wallbrackets")
    public ResponseEntity<List<WallBracketDto>> getAllWallBrackets() {
        return ResponseEntity.ok(wallBracketService.getAllWallBrackets());
    }

    @PostMapping("/wallbrackets")
    public ResponseEntity<WallBracketDto> createWallBracket(@Valid @RequestBody WallBracketInputDto wallBracketInputDto) {
        WallBracketDto wallBracketDto = wallBracketService.createWallBracket(wallBracketInputDto);
        return ResponseEntity.created(null).body(wallBracketDto);
    }

    @GetMapping("/wallbrackets/{id}")
    public ResponseEntity<WallBracketDto> getWallBracket(@PathVariable Long id) {
        return ResponseEntity.ok(wallBracketService.getOneWallBracket(id));
    }

    @DeleteMapping("/wallbrackets/{id}")
    public ResponseEntity<Optional<WallBracketDto>> deleteOneWallBracket(@PathVariable Long id) {
        wallBracketService.deleteWallBracket(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/wallbrackets/{id}")
    public ResponseEntity<WallBracketDto> updateWallBracket(@PathVariable Long id, @Valid @RequestBody WallBracketInputDto wallBracketInputDto) {
        WallBracketDto wallBracketDto1 = wallBracketService.updateWallbracket(id, wallBracketInputDto);
        return ResponseEntity.ok().body(wallBracketDto1);
    }
}
