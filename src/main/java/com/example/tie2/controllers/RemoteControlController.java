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
    public ResponseEntity<RemoteControlDto> createRemoteControl(@Valid @RequestBody RemoteControlInputDto remoteControlInputDto) {
        RemoteControlDto remoteControlDto = remoteControlService.createRemoteControlDto(remoteControlInputDto);
        return ResponseEntity.created(null).body(remoteControlDto);
    }

    @GetMapping("/remotecontrols/{id}")
    public ResponseEntity<RemoteControlDto> getRemoteControl(@PathVariable Long id) {
        return ResponseEntity.ok(remoteControlService.getOneRemoteControl(id));
    }

    @DeleteMapping("/remotecontrols/{id}")
    public ResponseEntity<Optional<RemoteControlDto>> deleteRemoteControl(@PathVariable Long id) {
        remoteControlService.deleteRemoteControl(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/remotecontrols/{id}")
    public ResponseEntity<RemoteControlDto> updateTelevision(@PathVariable Long id, @Valid @RequestBody RemoteControlInputDto remoteControlInputDto) {
        RemoteControlDto remoteControlInputDto1 = remoteControlService.updateRemoteControl(id, remoteControlInputDto);
        return ResponseEntity.ok().body(remoteControlInputDto1);
    }
}
