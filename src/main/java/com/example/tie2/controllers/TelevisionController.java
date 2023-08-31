package com.example.tie2.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TelevisionController {

    private List<Television> televisions;

    public TelevisionController() {
        televisions = new ArrayList<>();
        Television example = new Television("Samsung 22374", false, 4567); //pulling from Television class//
        Television example2 = new Television("LG-BB8", true, 78);
        Television example3 = new Television("Philips YoungGen-TV789", false, 89);
        televisions.add(example);
        televisions.add(example2);
        televisions.add(example3);
    }

    //TODO: need to make a database for the retrieval of televisions;//
    @GetMapping("/televisions/{id}") //gets back one single television // functional check //
    public ResponseEntity<Television> getOneTelevision(@PathVariable int id) {
        if (id >= 0 && id < televisions.size()) {
            Television getByIdTelevision = televisions.get(id);
            return new ResponseEntity<>(getByIdTelevision, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/televisions") //gets back all televisions of the database// //functional - check //
    public ResponseEntity<List<Television>> getTelevisions() {
        return new ResponseEntity<>(televisions, HttpStatus.OK);
    }

    @PostMapping("/televisions")
    public ResponseEntity<Television> postTelevision(@RequestBody Television newTelevision) {
        televisions.add(newTelevision);
        return new ResponseEntity<>(newTelevision, HttpStatus.CREATED);
    }

    @PutMapping("/televisions/{id}")
    public ResponseEntity<Television> updateTelevision(@PathVariable int id) {
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

