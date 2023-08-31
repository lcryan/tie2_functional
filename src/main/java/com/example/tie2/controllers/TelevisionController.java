package com.example.tie2.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TelevisionController {
    //TODO: 1. check, if all @methods are functional via postman //
    //TODO : 2. add exceptioncontroller to @methods, if id not found or similar"
    //TODO: 3. //
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

    @PostMapping("/televisions") //functional on postman - checked //
    public ResponseEntity<Television> postTelevision(@RequestBody Television newTelevision) {
        televisions.add(newTelevision);
        return new ResponseEntity<>(newTelevision, HttpStatus.CREATED);
    }

    @PutMapping("/televisions/{id}") // functional on postman //
    public ResponseEntity<Television> updateTelevision(@PathVariable int id, @RequestBody Television televisionDetails) {
        if (id >= 0 && id < televisions.size()) {
            Television updatedTelevision = televisions.get(id);
            updatedTelevision.setTelevisionName(televisionDetails.getTelevisionName());
            updatedTelevision.setHD(televisionDetails.getHD());
            updatedTelevision.setTotalStock(televisionDetails.getTotalStock());
            return new ResponseEntity<>(updatedTelevision, HttpStatus.OK);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/televisions/{id}")
    public ResponseEntity<Object> deleteTelevision(@PathVariable int id) {
        if (id >= 0 && id < televisions.size()) {
            Television televisionToDelete = televisions.remove(id);
            return new ResponseEntity<>(televisionToDelete, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}





