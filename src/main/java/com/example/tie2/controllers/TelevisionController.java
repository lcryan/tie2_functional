package com.example.tie2.controllers;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.mvc.method.annotation.ServletResponseMethodArgumentResolver;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TelevisionController {

    private List<Television> televisions;

    public TelevisionController() {
        televisions = new ArrayList<>();
        Television example = new Television("Samsung 22374", 3345); //pulling from Television class//
        televisions.add(example);
    }

    //TODO: need to make a database for the retrieval of televisions;//
    @GetMapping("/televisions/{id}") //gets back one single television //
    public ResponseEntity<Television> getTelevision(@PathVariable int id) {
        if (id >= 0 && id < televisions.size()) {
            Television example = televisions.get(id);
            return new ResponseEntity<>(example, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/televisions") //gets back all televisions of the database//
    public ResponseEntity<List<Television>> getTelevisions() {
        return new ResponseEntity<>(televisions, HttpStatus.OK); // could we also use ResponseEntity.ok ?
    }

    @PostMapping("/postTelevision")
    public ResponseEntity<Television> postTelevision(@RequestBody Television newTelevision) {
        televisions.add(newTelevision);
        return new ResponseEntity<>(newTelevision, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Television> updateTelevision(@PathVariable int id, String televisionName) {
        // do we need iterate here ???// // TODO: check in postman if functional //
        if (id >= 0 && id < televisions.size()) {
            Television televisionToUpdate = televisions.get(id);
            televisionToUpdate.setTelevisionName("LG-BB80KL");
            return ResponseEntity.ok(televisionToUpdate);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/delete/{id}") // hier kan je ook request params doen, als nodig //
    public ResponseEntity<Object> deleteTelevision(@PathVariable int id, @RequestBody Television television) {
        return ResponseEntity.noContent().build(); // 204 status
    } // TODO : needs to be finalized //
}

