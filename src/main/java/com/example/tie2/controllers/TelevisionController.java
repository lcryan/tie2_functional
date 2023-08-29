package com.example.tie2.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TelevisionController {

    //TODO: need to make a database for the retrieval of televisions;//
    @GetMapping("/television/{id}")
    public ResponseEntity<Television> getTelevisionById(@PathVariable(value = "id") Long id, Television television) {
        // TODO: need to build a method within class Television to retrieve televisionById - could be achieved with ById method? //
        return ResponseEntity.ok(television); // the ResponseEntity.ok(television) call creates a response with an HTTP status of 200 OK and includes television as the response body
    }

    @GetMapping("/allTelevisions") // same question here - do we need id ?? //
    public ResponseEntity<List<String>> getAllTelevisions(List<String> allTelevisions) {
        return ResponseEntity.ok(allTelevisions);

    }

    @PostMapping("/postTelevision")
    public ResponseEntity<Object> postTelevision(Television television) {
        television = new Television("Samsung 3", 90762639);
        return ResponseEntity.created(null).body(television);
    }

    @PostMapping("/postAllTelevisions")
    public ResponseEntity<List<String>> postAllTelevisions(List<String> allTelevisions) {
        return ResponseEntity.created(null).body(allTelevisions);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> putTelevision(@PathVariable long id, @RequestBody Television television) {
        // how to retrieve the actual television here ??? // //TODO: probably need a database to retrieve this from. //

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteTelevision(@PathVariable long id, @RequestBody Television television) {
        return ResponseEntity.noContent().build();
    }
}

