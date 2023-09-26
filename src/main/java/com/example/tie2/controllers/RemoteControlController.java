package com.example.tie2.controllers;


import com.example.tie2.dtos.RemoteControlDto;
import com.example.tie2.dtos.RemoteControlInputDto;
import com.example.tie2.services.RemoteControlService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RemoteControlController {

    private final RemoteControlService remoteControlService;

    public RemoteControlController(RemoteControlService remoteControlService) {
        this.remoteControlService = remoteControlService;
    }

    @GetMapping("/remotecontrols")
    public ResponseEntity<List<RemoteControlDto>> getAllRemoteControls() {
        List<RemoteControlDto> remoteControlDtoList = remoteControlService.getAllRemoteControls();
        return ResponseEntity.ok(remoteControlDtoList);
    }

    @PostMapping("/remotecontrols")
    public ResponseEntity<RemoteControlDto> createRemoteControl(@RequestBody RemoteControlInputDto inputDto) {
        RemoteControlDto remoteControlDtoOne = remoteControlService.createRemoteControlDto(inputDto);
        return ResponseEntity.created(null).body(remoteControlDtoOne);
    }

    @GetMapping("/remotecontrols/{id}")
    public ResponseEntity<RemoteControlDto> getRemoteControl(@PathVariable("id") Long id) { // this changes due to OneToOne relation //

        RemoteControlDto remoteDto = remoteControlService.getOneRemoteControl(id);
        return ResponseEntity.ok(remoteDto);
    }

    @DeleteMapping("/remotecontrols/{id}")
    public ResponseEntity<Optional<RemoteControlDto>> deleteRemoteControl(@PathVariable("id") Long id) { // see comment above //
        remoteControlService.deleteRemoteControl(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/remotecontrols/{id}")
    public ResponseEntity<RemoteControlInputDto> updateTelevision(@PathVariable("id") Long id, @RequestBody RemoteControlInputDto inputDto) {
        remoteControlService.updateRemoteControl(id, inputDto);
        return ResponseEntity.ok(inputDto);
    }
}
