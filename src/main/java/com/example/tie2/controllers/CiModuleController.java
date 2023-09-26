package com.example.tie2.controllers;

import com.example.tie2.dtos.CiModuleDto;
import com.example.tie2.dtos.CiModuleInputDto;
import com.example.tie2.services.CiModuleService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CiModuleController {
    private final CiModuleService ciModuleService;

    public CiModuleController(CiModuleService ciModuleService) {
        this.ciModuleService = ciModuleService;
    }

    @GetMapping("/cimodules")
    public ResponseEntity<List<CiModuleDto>> getAllCiModules() {
        List<CiModuleDto> ciModuleDtoList = ciModuleService.getAllCiModules();
        return ResponseEntity.ok(ciModuleDtoList);
    }

    @PostMapping("/cimodules")
    public ResponseEntity<CiModuleDto> createNewCiModule(@RequestBody CiModuleInputDto inputDto) {
        CiModuleDto inputCiModule = ciModuleService.createCiModule(inputDto);
        return ResponseEntity.created(null).body(inputCiModule);
    }

    @GetMapping("/cimodules/{id}")
    public ResponseEntity<CiModuleDto> getCiModule(@PathVariable Long id) {
        CiModuleDto ciModuleDto = ciModuleService.getOneCiModule(id);
        return ResponseEntity.ok(ciModuleDto);
    }

    @DeleteMapping("/cimodules/{id}")
    public ResponseEntity<Optional<CiModuleDto>> deleteCiModule(@PathVariable Long id) {
        ciModuleService.deleteCiModule(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("cimodules/{id}")
    public ResponseEntity<CiModuleDto> updateCiModule(@PathVariable Long id, @Valid @RequestBody CiModuleInputDto newCiModule) {
        CiModuleDto ciModuleDtoOne = ciModuleService.updateCiModule(id, newCiModule);
        return ResponseEntity.ok().body(ciModuleDtoOne);
    }
}
