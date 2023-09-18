package com.example.tie2.controllers;

import com.example.tie2.dtos.TelevisionDto;
import com.example.tie2.exceptions.TelevisionNotFoundException;
import com.example.tie2.services.TelevisionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class TelevisionController {

    private final TelevisionService televisionService;

    public TelevisionController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }

    // getting all Televisions through service //
    @GetMapping("/televisions")
    public ResponseEntity<List<TelevisionDto>> getAllTelevisions() {
        return ResponseEntity.ok(televisionService.getAllTelevisions());
    }

    @PostMapping("/televisions")
    public ResponseEntity<String> createTelevision(@Valid @RequestBody TelevisionDto televisionDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new TelevisionNotFoundException("Bad request");
        } else {
            Long createdId = televisionService.createTelevision(televisionDto);
            URI uri = URI.create(ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/televisions/" + createdId)
                    .toUriString());
            return ResponseEntity.created(uri).body("Television created.");
        }
    }

    @GetMapping("/televisions/{id}")
    public ResponseEntity<TelevisionDto> getTelevision(@PathVariable Long id) {
        return ResponseEntity.ok(televisionService.getOneTelevision(id));
    }
}

/*    private final TelevisionRepository televisionRepository;

    public TelevisionController(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    *//*  @GetMapping // getting all Televisions //
      public ResponseEntity<List<TelevisionDto>> getAllTelevisions() {
          for(Television television : televisions) {
          }
      }*//*

    @PostMapping
    public ResponseEntity<Television> createOneTelevision(@RequestBody Television television) {
        televisionRepository.save(television); // here an id is made for the new object television, which we are going to create//
        URI uri = URI.create(ServletUriComponentsBuilder.
                fromCurrentRequest(). //comment test //
                        path("/" + television.getId()).toUriString()); // here we make an uri string from the object //
        return ResponseEntity.created(uri).body(television);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Television> updateTelevision(@PathVariable Long id, @RequestBody Television television) {
        Optional<Television> optionalTelevision = televisionRepository.findById(id);
        if (optionalTelevision.isPresent()) {
            televisionRepository.save(television);
            return ResponseEntity.ok(television);
        } else {
            throw new TelevisionNotFoundException(); // could we also make an "update couldn't be processed ? //
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Television>> deleteOneTelevision(@PathVariable Long id) {
        Optional<Television> televisionOptional = televisionRepository.findById(id); //we have to make the first variable here to store the optional//
        if (televisionOptional.isPresent()) {
            Television television = televisionOptional.get(); // once there is an optional with id, we get() that one out and have to store it in a new variable to be able to delete the actual television that we found by id //
            televisionRepository.delete(television); // removal of television //
            return ResponseEntity.ok().build(); // functional in postman //
        } else {
            throw new TelevisionNotFoundException("Requested object not found."); // functional in postman //
        }
    }
}*/



