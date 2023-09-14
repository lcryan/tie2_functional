package com.example.tie2.services;

import com.example.tie2.dtos.TelevisionDto;
import com.example.tie2.exceptions.TelevisionNotFoundException;
import com.example.tie2.models.Television;
import com.example.tie2.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
            televisionDto.setId(television.getId());
            televisionDto.setBrand(television.getBrand());
            televisionDto.setName(television.getName());
            televisionDto.setPrice(television.getPrice());
            televisionDto.setAvailableSize(television.getAvailableSize());
            televisionDto.setScreenQuality(television.getScreenQuality());
            televisionDto.setSmartTv(television.isSmartTv());
            televisionDto.setWifi(television.isWifi());
            televisionDto.setVoiceControl(television.isVoiceControl());
            televisionDto.setHdr(television.isHdr());
            televisionDto.setBluetooth(television.isBluetooth());
            televisionDto.setAmbiLight(television.isAmbiLight());
            televisionDto.setOriginalStock(television.getOriginalStock());
            televisionDto.setOriginalStock(television.getOriginalStock());
            televisionDto.setSold(television.getSold());
            televisionDto.setDateOfPurchase(television.getDateOfPurchase());
            televisionDto.setCurrentStock(television.getCurrentStock());
            televisionDto.setEnergyLabel(television.getEnergyLabel());
        }
        return televisionDtos;
    }

    public TelevisionDto getOneTelevision(Long id) {
        Optional<Television> optionalTelevision =televisionRepository.findById(id);
        if (optionalTelevision.isPresent()) {
            Television televisionDto = optionalTelevision.get();
            return new TelevisionDto(televisionDto);


        } else {
            throw new TelevisionNotFoundException("No television found with the following id " + id + ".");
        }
    }

}


// TODO here:
//  2. a function to get one television;
//  3. a function to post one television;
//  4. a function to delete one television;
//  5. a function to update one television //