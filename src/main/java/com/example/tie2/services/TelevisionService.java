package com.example.tie2.services;

import com.example.tie2.dtos.TelevisionDto;
import com.example.tie2.models.Television;
import com.example.tie2.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;

    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    } // this is an autowired construction injection - use this instead of @Autowired! //

    public List<TelevisionDto> getAllTelevisions() {
        List<Television> televisions = televisionRepository.findAll();
        List<TelevisionDto> televisionDtos = new ArrayList<>(); // watch out: in case you have a list, don't forget to use plural - here: televisions//
        for (Television television : televisions) {
            TelevisionDto televisionDto = new TelevisionDto();
            televisionDto.setBrand(television.getBrand());
            // TODO : add all attributes here //
        }
        return televisionDtos;
    }
}


// TODO here: 1. make function to get all televisions;
//  2. a function to get one television;
//  3. a function to post one television;
//  4. a function to delete one television;
//  5. a function to update one television //