package com.example.tie2.controllers;

import com.example.tie2.exceptions.TelevisionNotFoundException;
import com.example.tie2.repositories.TelevisionRepository;
import com.example.tie2.models.Television;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    private final TelevisionRepository televisionRepository;

    public TelevisionController(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }


    @GetMapping("/televisions/{id}") //gets back one single television // functional check //
    public ResponseEntity<Television> getOneTelevision(@PathVariable Long id) {
        Optional<Television> television = televisionRepository.findById(id);
        if (id >= 0 && id < televisions.size()) {
            Television getByIdTelevision = televisions.get(id);
            return new ResponseEntity<>(getByIdTelevision, HttpStatus.OK);
        } else {
            throw new TelevisionNotFoundException("The requested object television cannot be found."); //prints this message, if television not found//
            /*return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);*/  //uncommented - to check, if throw Exception works //
        }
    }

    @GetMapping("/televisions") //gets back all televisions of the database// //functional - check //
    public ResponseEntity<List<Television>> getAllTelevisions(@RequestParam(value = "brand", required = false) String brand) {
        List<Television> televisions;

        if (brand == null) {
            televisions = televisionRepository.findAll();
        }
    } else

    {

    }
}





