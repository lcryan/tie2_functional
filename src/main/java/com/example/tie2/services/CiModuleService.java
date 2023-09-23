package com.example.tie2.services;

import com.example.tie2.dtos.CiModuleDto;
import com.example.tie2.dtos.CiModuleInputDto;
import com.example.tie2.models.CiModule;
import com.example.tie2.repositories.CiModuleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CiModuleService {

    private final CiModuleRepository ciModuleRepository;

    public CiModuleService(CiModuleRepository ciModuleRepository) {

        this.ciModuleRepository = ciModuleRepository;
    }

    public List<CiModuleDto> getAllCiModules() {
        List<CiModule> ciModules = ciModuleRepository.findAll();
        List<CiModuleDto> ciModuleDtos = new ArrayList<>();
    }

    // helper methods for conversion model - dto - input dto - model //

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
