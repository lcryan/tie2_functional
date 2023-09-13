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
    }

    public List<TelevisionDto> getAllTelevisions() {
        List<Television> televisions = televisionRepository.findAll();
        List<TelevisionDto> televisionDtos = new ArrayList<>(); // altijd meervoud !! //
        for (Television television : televisions) {
            TelevisionDto televisionDto = new TelevisionDto();
            televisionDto.setBrand(television.getBrand());
            // TODO : add all attributes here //
        }
        return televisionDtos;
    }
}
