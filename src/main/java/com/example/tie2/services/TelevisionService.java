package com.example.tie2.services;

import com.example.tie2.dtos.TelevisionDto;
import com.example.tie2.dtos.TelevisionInputDto;
import com.example.tie2.exceptions.TelevisionNotFoundException;
import com.example.tie2.models.Television;
import com.example.tie2.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

    public TelevisionDto createTelevision(TelevisionInputDto televisionInputDto) {
        Television newTv = transferTelevisionInputDtoToTelevision(televisionInputDto);
        televisionRepository.save(newTv);
        return transferTelevisionToTelevisionDto(newTv);
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

    public void deleteTelevision(Long id) {
        if (televisionRepository.existsById(id)) {
            Optional<Television> toBeDeletedTelevision = televisionRepository.findById(id);
            Television televisionD = toBeDeletedTelevision.get();
            televisionRepository.delete(televisionD);
        } else {
            throw new TelevisionNotFoundException("Television item with id: " + " cannot be found.");
        }
    }

    public TelevisionDto updateTelevision(@PathVariable Long id, TelevisionInputDto upTelevision) {
        Optional<Television> optionalTelevision = televisionRepository.findById(id);
        if (optionalTelevision.isPresent()) {
            Television televisionOne = optionalTelevision.get();

            televisionOne.setBrand(upTelevision.getBrand());
            // enz. //
            Television updatedTelevision = televisionRepository.save(televisionOne);

            return transferTelevisionToTelevisionDto(updatedTelevision);

        } else {
            throw new TelevisionNotFoundException("item couldn't be found");
        }
    }

// ******* helper methods here: ******* //


    // transferring Television to TelevisionDto //
    public TelevisionDto transferTelevisionToTelevisionDto(Television television) {
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

        return televisionDto;
    }

    // transferring TelevisionInputDto to Television //
    public Television transferTelevisionInputDtoToTelevision(TelevisionInputDto televisionInputDto) {
        var television = new Television();
        television.setBrand(televisionInputDto.getBrand());
        television.setName(televisionInputDto.getName());
        television.setPrice(televisionInputDto.getPrice());
        television.setAvailableSize(televisionInputDto.getAvailableSize());
        television.setScreenQuality(televisionInputDto.getScreenQuality());
        television.setSmartTv(televisionInputDto.isSmartTv());
        television.setWifi(televisionInputDto.isWifi());
        television.setVoiceControl(televisionInputDto.isVoiceControl());
        television.setHdr(televisionInputDto.isHdr());
        television.setBluetooth(televisionInputDto.isBluetooth());
        television.setAmbiLight(televisionInputDto.isAmbiLight());
        television.setOriginalStock(televisionInputDto.getOriginalStock());
        television.setSold(televisionInputDto.getSold());
        television.setDateOfPurchase(televisionInputDto.getDateOfPurchase());
        television.setCurrentStock(televisionInputDto.getCurrentStock());
        television.setEnergyLabel(televisionInputDto.getEnergyLabel());
        return television;
    }
}



