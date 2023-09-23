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
        List<CiModule> ciModules = ciModuleRepository.findAll();
        List<CiModuleDto> ciModuleDtos = new ArrayList<>();
        for (CiModule ciModule : ciModules) {
            CiModuleDto ciModuleDto = transferCiModuleToCiModuleDto(ciModule);
            ciModuleDtos.add(ciModuleDto);
        }
        return ciModuleDtos;
    }

    public CiModuleDto createCiModule(CiModuleInputDto ciModuleInputDto) {
        CiModule newCiModule = transferCiModuleInputDtoToCiModule(ciModuleInputDto);
        ciModuleRepository.save(newCiModule);
        return transferCiModuleToCiModuleDto(newCiModule);
    }

    public CiModuleDto getOneCiModule(Long id) {
        Optional<CiModule> optionalCiModule = ciModuleRepository.findById(id);
        if (optionalCiModule.isPresent()) {
            CiModule ciModule = optionalCiModule.get();
            return transferCiModuleToCiModuleDto(ciModule);
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

    public CiModuleDto updateCiModule(@PathVariable Long id, CiModuleInputDto upCiModule) {
        Optional<CiModule> optionalCiModule = ciModuleRepository.findById(id);
        if (optionalCiModule.isPresent()) {
            CiModule ciModuleOne = optionalCiModule.get();

            ciModuleOne.setId(upCiModule.getId());
            ciModuleOne.setName(upCiModule.getName());
            ciModuleOne.setType(upCiModule.getType());
            ciModuleOne.setPrice(upCiModule.getPrice());

            CiModule updatedCiModule = ciModuleRepository.save(ciModuleOne);

            return transferCiModuleToCiModuleDto(updatedCiModule);
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
        ciModuleInputDto.setName(ciModuleInputDto.getName());
        ciModuleInputDto.setType(ciModuleInputDto.getType());
        ciModuleInputDto.setPrice(ciModuleInputDto.getPrice());

        return ciModule;
    }

}
