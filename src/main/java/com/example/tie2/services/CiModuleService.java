package com.example.tie2.services;

import com.example.tie2.dtos.CiModuleDto;
import com.example.tie2.dtos.CiModuleInputDto;

import com.example.tie2.exceptions.RecordNotFoundException;
import com.example.tie2.models.CiModule;

import com.example.tie2.repositories.CiModuleRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CiModuleService {

    private final CiModuleRepository ciModuleRepository;

    public CiModuleService(CiModuleRepository ciModuleRepository) {
        this.ciModuleRepository = ciModuleRepository;
    }

    public List<CiModuleDto> getAllCiModules() {
        List<CiModule> ciModuleList = ciModuleRepository.findAll();
        List<CiModuleDto> ciModuleDtoList = new ArrayList<>();
        for (CiModule ci : ciModuleList) {
            CiModuleDto ciModuleDto = transferCiModuleToCiModuleDto(ci);
            ciModuleDtoList.add(ciModuleDto);
        }
        return ciModuleDtoList;
    }

    public CiModuleDto createCiModule(CiModuleInputDto inputDto) {
        CiModule newCiModule = transferCiModuleInputDtoToCiModule(inputDto);
        ciModuleRepository.save(newCiModule);
        return transferCiModuleToCiModuleDto(newCiModule);
    }

    public CiModuleDto getOneCiModule(Long id) {
        Optional<CiModule> optionalCiModule = ciModuleRepository.findById(id);
        if (optionalCiModule.isPresent()) {
            CiModuleDto ciModule = transferCiModuleToCiModuleDto(optionalCiModule.get());
            return ciModule;
        } else {
            throw new RecordNotFoundException("Item of type Ci-Module with id: " + id + " could not be found.");
        }
    }

    public void deleteCiModule(Long id) {
        if (ciModuleRepository.existsById(id)) {
            Optional<CiModule> toBeDeletedCiModule = ciModuleRepository.findById(id);
            CiModule ciModuleD = toBeDeletedCiModule.get();
            ciModuleRepository.delete(ciModuleD);
        } else {
            throw new RecordNotFoundException("Item of type Ci-Module with id: " + id + " could not be found.");
        }
    }

    public CiModuleDto updateCiModule(Long id, CiModuleInputDto ciModuleInputDto) {
        if (ciModuleRepository.findById(id).isPresent()) {

            CiModule ciModule = ciModuleRepository.findById(id).get();

            CiModule ciModule1 = transferCiModuleInputDtoToCiModule(ciModuleInputDto);

            ciModule1.setId(ciModule.getId());

            ciModuleRepository.save(ciModule1);

            return transferCiModuleToCiModuleDto(ciModule1);
        } else {
            throw new RecordNotFoundException("Item of type Ci-Module with id: " + id + " could not be found.");
        }
    }


    // -------------------------------------------------------------- //

    // HELPER METHODS for conversion CIMODULE:  model - dto - input dto - model //

    public CiModuleDto transferCiModuleToCiModuleDto(CiModule ciModule) {
        CiModuleDto ciModuleDto = new CiModuleDto();
        ciModuleDto.setId(ciModule.getId());
        ciModuleDto.setName(ciModule.getName());
        ciModuleDto.setType(ciModule.getType());
        ciModuleDto.setPrice(ciModule.getPrice());

        return ciModuleDto;
    }

    public CiModule transferCiModuleInputDtoToCiModule(CiModuleInputDto ciModuleInputDto) {
        var ciModule = new CiModule();

        ciModule.setId(ciModuleInputDto.getId());
        ciModule.setName(ciModuleInputDto.getName());
        ciModule.setType(ciModuleInputDto.getType());
        ciModule.setPrice(ciModuleInputDto.getPrice());

        return ciModule;
    }

}
