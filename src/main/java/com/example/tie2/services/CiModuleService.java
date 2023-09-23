package com.example.tie2.services;

import com.example.tie2.dtos.CiModuleDto;
import com.example.tie2.dtos.CiModuleInputDto;
import com.example.tie2.models.CiModule;
import org.springframework.stereotype.Service;

@Service
public class CiModuleService {

    private final CiModuleService ciModuleService;

    public CiModuleService(CiModuleService ciModuleService) {
        this.ciModuleService = ciModuleService;
    }

    // helper methods for conversion model - dto- input dto //

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
