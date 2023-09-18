package com.example.tie2.services;

import com.example.tie2.dtos.TelevisionDto;
import com.example.tie2.exceptions.TelevisionNotFoundException;
import com.example.tie2.models.Television;
import com.example.tie2.repositories.TelevisionRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

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
            TelevisionDto televisionDto = transferTelevisionToTelevisionDto(television);
            televisionDtos.add(televisionDto);
        }
        return televisionDtos;
    }

    public Long createTelevision(TelevisionDto televisionDto) {
        Television newTelevision;
        newTelevision = transferTelevisionDtoToTelevision(televisionDto);
        Television savedTelevision = televisionRepository.save(newTelevision);
        return savedTelevision.getId();
    }

    public TelevisionDto getOneTelevision(Long id) {
        Optional<Television> optionalTelevision = televisionRepository.findById(id);
        if (optionalTelevision.isPresent()) {
            Television television = optionalTelevision.get();
            return transferTelevisionToTelevisionDto(television);

        } else {
            throw new TelevisionNotFoundException("No television found with the following id " + id + ".");
        }
    }

// ******* helper methods here: ******* //

    private TelevisionDto transferTelevisionToTelevisionDto(Television television) {
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
        televisionDto.setSold(television.getSold());
        televisionDto.setDateOfPurchase(television.getDateOfPurchase());
        televisionDto.setCurrentStock(television.getCurrentStock());
        televisionDto.setEnergyLabel(television.getEnergyLabel());
        televisionDto.setTelevision(television.getTelevision());
        return televisionDto;
    }

    private Television transferTelevisionDtoToTelevision(TelevisionDto televisionDto) {
        Television television = new Television();
        television.setId(televisionDto.getId());
        television.setBrand(televisionDto.getBrand());
        television.setName(televisionDto.getName());
        television.setPrice(televisionDto.getPrice());
        television.setAvailableSize(televisionDto.getAvailableSize());
        television.setScreenQuality(televisionDto.getScreenQuality());
        television.setSmartTv(televisionDto.isSmartTv());
        television.setWifi(televisionDto.isWifi());
        television.setVoiceControl(televisionDto.isVoiceControl());
        television.setHdr(televisionDto.isHdr());
        television.setBluetooth(televisionDto.isBluetooth());
        television.setAmbiLight(televisionDto.isAmbiLight());
        television.setOriginalStock(televisionDto.getOriginalStock());
        television.setSold(televisionDto.getSold());
        television.setDateOfPurchase(televisionDto.getDateOfPurchase());
        television.setCurrentStock(televisionDto.getCurrentStock());
        television.setEnergyLabel(televisionDto.getEnergyLabel());
        television.setTelevision(televisionDto.getTelevision());
        return television;
    }

    public List<Television> transferTelevisionDtoListToTelevisionList(List<TelevisionDto> televisionDtos) {
        List<Television> televisions = new ArrayList<>();
        for (TelevisionDto televisionDto : televisionDtos) {
            televisions.add(transferTelevisionDtoToTelevision(televisionDto));
        }
        return televisions;
    }
}


// TODO:
//  2. a function to get one television;

//  4. a function to delete one television;
//  5. a function to update one television //