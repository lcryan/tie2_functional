package com.example.tie2.controllers;

import com.example.tie2.dtos.IdInputDto;

import com.example.tie2.dtos.TelevisionDto;
import com.example.tie2.dtos.TelevisionInputDto;

import com.example.tie2.services.TelevisionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TelevisionController {

    private final TelevisionService televisionService;

    public TelevisionController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }

    @GetMapping("/televisions")
    public ResponseEntity<List<TelevisionDto>> getAllTelevisions() {
        List<TelevisionDto> televisionDtoList = televisionService.getAllTelevisions();
        return ResponseEntity.ok(televisionDtoList);
    }

    @PostMapping("/televisions")
    public ResponseEntity<Object> createTelevision(@Valid @RequestBody TelevisionInputDto inputDto, BindingResult bindingResult) { // why do they use Object here instead of just TelevisionDto?? //
        TelevisionDto televisionDto = televisionService.createTelevision(inputDto);
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
            return ResponseEntity.created(null).body(televisionDto);
        }
    }

    @GetMapping("/televisions/{id}")
    public ResponseEntity<TelevisionDto> getTelevision(@PathVariable("id") Long id) {
        TelevisionDto television = televisionService.getOneTelevision(id);
        return ResponseEntity.ok().body(television);
    }

    @DeleteMapping("/televisions/{id}")
    public ResponseEntity<Object> deleteOneTelevision(@PathVariable Long id) {
        televisionService.deleteTelevision(id); // calling on function in service //
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/televisions/{id}")
    public ResponseEntity<Object> updateTelevision(@PathVariable Long id, @Valid @RequestBody TelevisionInputDto
            newTele) {
        TelevisionDto televisionInputDtoOne = televisionService.updateTelevision(id, newTele);
        return ResponseEntity.ok().body(televisionInputDtoOne);
    }

    // assigning remote control to television //
    @PutMapping("/televisions/{id}/remotecontrol")
    public ResponseEntity<Object> assignRemoteControlToTelevision(@PathVariable("id") Long
                                                                          id, @RequestBody IdInputDto input) {
        televisionService.assignRemoteControlToTelevision(id, input.id);
        return ResponseEntity.ok().build();
    }
}




