package com.example.tie2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TelevisionController {


    @GetMapping("/television/{id}") // do we have to add ID here ? and if not, then when ? //
    // defining a single endpoint using @GetMapping annotation with the path getTelevision - when a get request is made to this endpoint the getTelevision will be executed.
    public ResponseEntity<Television> getTelevisionById(@PathVariable(value = "id") Long televisionId, Television television) {
        return ResponseEntity.ok(television); // the ResponseEntity.ok(television) call creates a response with an HTTP status of 200 OK and includes television as the response body
    }

    @GetMapping("/getAllTelevisions") // same question here - do we need id ?? //
    public ResponseEntity<List<String>> getAllTelevisions(List<String> allTelevisions) {
        return ResponseEntity.ok(allTelevisions);

    }

    @PostMapping("/postTelevision")
    public ResponseEntity<Object> postTelevision() {
        String television = "Samsung BB6547";
        return ResponseEntity.created(null).body(television);
    }

    @PostMapping("/postAllTelevisions")
    public ResponseEntity<List<String>> postAllTelevisions(List<String> allTelevisions) {
        return ResponseEntity.created(null).body(allTelevisions);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> putTelevision(@PathVariable long id, @RequestBody String updatedTelevision) {
        // how to retrieve the actual television here ??? //

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTelevision(@PathVariable long id, @RequestBody String deletedTelevision) {
        return ResponseEntity.noContent().build();
    }
}

// notes: maybe better to change updated and deletedTelevision into general television ?? //
