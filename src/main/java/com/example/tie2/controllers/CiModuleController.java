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
        return ResponseEntity.ok(ciModuleService.getAllCiModules());
    }

    @PostMapping("/cimodules")
    public ResponseEntity<CiModuleDto> createNewCiModule(@Valid @RequestBody CiModuleInputDto ciModuleInputDto) {
        CiModuleDto ciModuleDto = ciModuleService.createCiModule(ciModuleInputDto);
        return ResponseEntity.created(null).body(ciModuleDto);
    }

    @GetMapping("/cimodules/{id}")
    public ResponseEntity<CiModuleDto> getCiModule(@PathVariable Long id) {
        return ResponseEntity.ok(ciModuleService.getOneCiModule(id));
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
