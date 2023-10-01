package com.example.tie2.services;

import com.example.tie2.dtos.TelevisionDto;
import com.example.tie2.dtos.TelevisionInputDto;
import com.example.tie2.exceptions.RecordNotFoundException;
import com.example.tie2.exceptions.TelevisionNotFoundException;
import com.example.tie2.models.CiModule;
import com.example.tie2.models.Television;
import com.example.tie2.repositories.CiModuleRepository;
import com.example.tie2.repositories.RemoteControlRepository;
import com.example.tie2.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;
    private final RemoteControlRepository remoteControlRepository;

    private final CiModuleRepository ciModuleRepository;

    private final RemoteControlService remoteControlService;

    private final CiModuleService ciModuleService;

    // DON"T FORGET TO ADD REMOTE CONTROL & CI MODULE REPO && SERVICE !!! //
    public TelevisionService(TelevisionRepository televisionRepository, RemoteControlRepository remoteControlRepository, CiModuleRepository ciModuleRepository, RemoteControlService remoteControlService, CiModuleService ciModuleService) {
        this.televisionRepository = televisionRepository;
        this.remoteControlRepository = remoteControlRepository;
        this.ciModuleRepository = ciModuleRepository;

        this.remoteControlService = remoteControlService;
        this.ciModuleService = ciModuleService;
    } // this is an autowired construction injection - use this instead of @Autowired! // // why did you use this ? Could be  one of the 5 argumentations for taking technical decisions //

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


    public TelevisionDto updateTelevision(Long id, TelevisionInputDto inputDto) {

        if (televisionRepository.findById(id).isPresent()) {

            Television tv = televisionRepository.findById(id).get();

            Television tv1 = transferTelevisionInputDtoToTelevision(inputDto);
            tv1.setId(tv.getId());

            televisionRepository.save(tv1);

            return transferTelevisionToTelevisionDto(tv1);

        } else {

            throw new TelevisionNotFoundException("No television found");

        }

    }

    // 3. Third step: assigning remote control to television function - ONE-TO-ONE RELATION between Television and Remote Controller //

    public void assignRemoteControlToTelevision(Long id, Long remoteControlId) {
        var optionalTelevision = televisionRepository.findById(id);
        var optionalRemoteControl = remoteControlRepository.findById(remoteControlId);
        if (optionalTelevision.isPresent() && optionalRemoteControl.isPresent()) {
            var television = optionalTelevision.get();
            var remoteControl = optionalRemoteControl.get();
            television.setRemoteControl(remoteControl);
            televisionRepository.save(television);
        } else {
            throw new TelevisionNotFoundException("Not found.");
        }
    }


    // MANY-TO-ONE RELATION WITH CI-MODULE - assign CiModule to Television within a function //

    public void assignCiModuleToTelevision(Long televisionId, Long ciModuleId) {
        var optionalCiModule = ciModuleRepository.findById(ciModuleId);
        var optionalTelevision = televisionRepository.findById(televisionId);

        if (optionalTelevision.isPresent() && optionalCiModule.isPresent()) {
            Television television = optionalTelevision.get();
            CiModule ciModule = optionalCiModule.get();

            television.setCiModule(ciModule);
            televisionRepository.save(television);

        } else {
            throw new RecordNotFoundException("Item with id " + ciModuleId + "could not be found.");
        }
    }


// ******* helper methods here: ******* //


    // transferring Television to TelevisionDto //
    public TelevisionDto transferTelevisionToTelevisionDto(Television television) {
        TelevisionDto televisionDto = new TelevisionDto();
        televisionDto.setId(television.getId());
        televisionDto.setType(television.getType());
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
        televisionDto.setRefreshRate(television.getRefreshRate());
        televisionDto.setScreenType(television.getScreenType());

        if (television.getRemoteControl() != null) {
            televisionDto.setRemoteControlDto(remoteControlService.transferRemoteControlToRemoteControlDto(television.getRemoteControl()));
        }
        if (television.getCiModule() != null) {
            televisionDto.setCiModuleDto(ciModuleService.transferCiModuleToCiModuleDto(television.getCiModule()));
        }

        return televisionDto;
    }

    // transferring TelevisionInputDto to Television //
    public Television transferTelevisionInputDtoToTelevision(TelevisionInputDto inputDto) {
        var television = new Television();

        television.setBrand(inputDto.getBrand());
        television.setType(inputDto.getType());
        television.setName(inputDto.getName());
        television.setPrice(inputDto.getPrice());
        television.setAvailableSize(inputDto.getAvailableSize());
        television.setScreenQuality(inputDto.getScreenQuality());
        television.setSmartTv(inputDto.isSmartTv());
        television.setWifi(inputDto.isWifi());
        television.setVoiceControl(inputDto.isVoiceControl());
        television.setHdr(inputDto.isHdr());
        television.setBluetooth(inputDto.isBluetooth());
        television.setAmbiLight(inputDto.isAmbiLight());
        television.setOriginalStock(inputDto.getOriginalStock());
        television.setSold(inputDto.getSold());
        television.setDateOfPurchase(inputDto.getDateOfPurchase());
        television.setCurrentStock(inputDto.getCurrentStock());
        television.setEnergyLabel(inputDto.getEnergyLabel());
        television.setRefreshRate(inputDto.getRefreshRate());
        television.setScreenType(inputDto.getScreenType());
        return television;
    }
}



