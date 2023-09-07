package com.example.tie2.controllers;

import com.example.tie2.exceptions.TelevisionNotFoundException;
import com.example.tie2.repositories.TelevisionRepository;
import com.example.tie2.models.Television;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    @Autowired
    private TelevisionRepository televisionRepository;

    @GetMapping // getting all Televisions //
    public ResponseEntity<List<Television>> getTelevisions() {
        return ResponseEntity.ok(televisionRepository.findAll()); // gives back all televisions //
    }

    @GetMapping("/{id}") // get one television by Id //
    public ResponseEntity<Optional<Television>> getOneTelevision(@PathVariable Long id) {
        Optional<Television> television = televisionRepository.findById(id);
        if (television.isPresent()) {
            return ResponseEntity.ok(television); // this returns a television by id - the television id exists in this case //
        } else {
            throw new TelevisionNotFoundException("Requested object couldn't be found.");
        }
    }

    @PostMapping
    public ResponseEntity<Television> createOneTelevision(@RequestBody Television television) {
        televisionRepository.save(television); // here an id is made for the new object television, which we are going to create//
        URI uri = URI.create(ServletUriComponentsBuilder.
                fromCurrentRequest(). //comment test //
                        path("/" + television.getId()).toUriString()); // here we make an uri string from the object //
        return ResponseEntity.created(uri).body(television);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Television>> deleteOneTelevision(@PathVariable Long id) {
        Optional<Television> televisionOptional = televisionRepository.findById(id);
        if (televisionOptional.isPresent()) {
            Television television = televisionOptional.get();
            televisionRepository.delete(television);
            return ResponseEntity.ok().build();
        } else {
            throw new TelevisionNotFoundException("Requested object not found.");
        }
    }
}






