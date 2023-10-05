package com.example.tie2.controllers;


import com.example.tie2.dtos.RemoteControlDto;
import com.example.tie2.dtos.inputDtos.RemoteControlInputDto;
import com.example.tie2.services.RemoteControlService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Object> createRemoteControl(@RequestBody RemoteControlInputDto inputDto, BindingResult bindingResult) {
        RemoteControlDto remoteControlDtoOne = remoteControlService.createRemoteControlDto(inputDto);
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
            return ResponseEntity.created(null).body(remoteControlDtoOne);
        }
    }

    @GetMapping("/remotecontrols/{id}")
    public ResponseEntity<RemoteControlDto> getRemoteControl(@PathVariable("id") Long id) { // this changes due to OneToOne relation //

        RemoteControlDto remoteDto = remoteControlService.getOneRemoteControl(id);
        return ResponseEntity.ok(remoteDto);
    }

    @DeleteMapping("/remotecontrols/{id}")
    public ResponseEntity<Object> deleteRemoteControl(@PathVariable("id") Long id) { // see comment above //
        remoteControlService.deleteRemoteControl(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/remotecontrols/{id}")
    public ResponseEntity<Object> updateRemoteControl(@PathVariable Long id, @Valid @RequestBody RemoteControlInputDto remoteControlInputDto) {

        RemoteControlDto remoteControlDto = remoteControlService.updateRemoteControl(id, remoteControlInputDto);

        return ResponseEntity.ok().body(remoteControlDto);
    }
}
