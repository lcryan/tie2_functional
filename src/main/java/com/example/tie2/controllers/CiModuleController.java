package com.example.tie2.controllers;

import com.example.tie2.dtos.CiModuleDto;
import com.example.tie2.dtos.CiModuleInputDto;
import com.example.tie2.services.CiModuleService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    } // functional //

    @PostMapping("/cimodules")
    public ResponseEntity<Object> createNewCiModule(@Valid @RequestBody CiModuleInputDto inputDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            StringBuilder sb = new StringBuilder();
            for (FieldError fe : bindingResult.getFieldErrors()) {
                sb.append(fe.getField());
                sb.append(" : ");
                sb.append(fe.getDefaultMessage());
                sb.append("\n");
            }
            return ResponseEntity.badRequest().body(sb.toString());
        } else {
            CiModuleDto ciModuleDto = ciModuleService.createCiModule(inputDto);
            return ResponseEntity.created(null).body(ciModuleDto);
        }
    } // functional //

    // REMEMBER : the binding result makes sure that you see the default message in postman and not only in IntelliJ !! //
    @GetMapping("/cimodules/{id}")
    public ResponseEntity<CiModuleDto> getCiModule(@PathVariable Long id) {
        CiModuleDto ciModuleDto = ciModuleService.getOneCiModule(id);
        return ResponseEntity.ok(ciModuleDto);
    } // functional //

    @DeleteMapping("/cimodules/{id}")
    public ResponseEntity<Object> deleteCiModule(@PathVariable Long id) {
        ciModuleService.deleteCiModule(id);
        return ResponseEntity.noContent().build();
    } // functional //

    @PutMapping("cimodules/{id}")
    public ResponseEntity<CiModuleDto> updateCiModule(@PathVariable Long id, @Valid @RequestBody CiModuleInputDto ciModuleInputDto) {
        CiModuleDto ciModuleDtoOne = ciModuleService.updateCiModule(id, ciModuleInputDto);
        return ResponseEntity.ok().body(ciModuleDtoOne);
    }
}
