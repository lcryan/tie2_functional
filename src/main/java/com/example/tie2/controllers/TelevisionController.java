package com.example.tie2.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TelevisionController {

    private List<Television> televisions;

    public TelevisionController() {
        televisions = new ArrayList<>();
        Television example = new Television("Samsung 22374", 3345);
        televisions.add(example);
    }

    //TODO :  add private final TelevisionRepository repository; check code from lesson in Robert-Jan folder//
    //TODO: need to make a database for the retrieval of televisions;//
    @GetMapping("/televisions/{id}")
    public ResponseEntity<Television> getTelevisionById(@PathVariable(value = "id") Long id, Television television) {

        return ResponseEntity.ok(television); // the ResponseEntity.ok(television) call creates a response with an HTTP status of 200 OK and includes television as the response body
    }

    @GetMapping("/allTelevisions") // no id needed here! //
    public ResponseEntity<List<String>> getAllTelevisions(List<String> allTelevisions) {
        return ResponseEntity.ok(allTelevisions);

    }

    @PostMapping("/postTelevision") //TODO: add id here //
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

    @DeleteMapping("/delete/{id}") // hier kan je ook request params doen, als nodig //
    public ResponseEntity<Object> deleteTelevision(@PathVariable long id, @RequestBody Television television) {
        return ResponseEntity.noContent().build(); // 204 status
    }
}

