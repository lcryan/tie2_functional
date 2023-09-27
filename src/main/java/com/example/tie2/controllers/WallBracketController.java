package com.example.tie2.controllers;

import com.example.tie2.dtos.WallBracketDto;
import com.example.tie2.dtos.WallBracketInputDto;
import com.example.tie2.services.WallBracketService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class WallBracketController {

    private final WallBracketService wallBracketService;

    public WallBracketController(WallBracketService wallBracketService) {
        this.wallBracketService = wallBracketService;
    }

    @GetMapping("/wallbrackets")
    public ResponseEntity<List<WallBracketDto>> getAllWallBrackets() {

        List<WallBracketDto> wallBracketDtoList = wallBracketService.getAllWallBrackets();
        return ResponseEntity.ok(wallBracketDtoList);
    }

    @PostMapping("/wallbrackets")
    public ResponseEntity<Object> createWallBracket(@RequestBody WallBracketInputDto inputDto, BindingResult bindingResult) {
        WallBracketDto wallBracket = wallBracketService.createWallBracket(inputDto);
        if (bindingResult.hasFieldErrors()) {
            StringBuilder sb = new StringBuilder();
            for (FieldError fe : bindingResult.getFieldErrors()) {
                sb.append(fe.getField());
                sb.append(" : ");
                sb.append(fe.getDefaultMessage());
                sb.append("\n");
            }
            return ResponseEntity.badRequest().body(sb.toString());
        } else {
            return ResponseEntity.created(null).body(wallBracket);
        }
    }

    @GetMapping("/wallbrackets/{id}")
    public ResponseEntity<WallBracketDto> getWallBracket(@PathVariable Long id) {

        WallBracketDto wallBracketDto = wallBracketService.getOneWallBracket(id);
        return ResponseEntity.ok(wallBracketDto);
    }

    @DeleteMapping("/wallbrackets/{id}")
    public ResponseEntity<Object> deleteOneWallBracket(@PathVariable Long id) {
        wallBracketService.deleteWallBracket(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/wallbrackets/{id}")
    public ResponseEntity<WallBracketDto> updateWallBracket(@PathVariable Long
                                                                    id, @Valid @RequestBody WallBracketInputDto wallBracketInputDto) {
        WallBracketDto wallBracketDto1 = wallBracketService.updateWallbracket(id, wallBracketInputDto);
        return ResponseEntity.ok().body(wallBracketDto1);
    }
}
