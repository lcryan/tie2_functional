package com.example.tie2.services;

import com.example.tie2.dtos.RemoteControlDto;
import com.example.tie2.dtos.RemoteControlInputDto;
import com.example.tie2.exceptions.RecordNotFoundException;
import com.example.tie2.models.RemoteControl;
import com.example.tie2.repositories.RemoteControlRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RemoteControlService {

    private final RemoteControlRepository remoteControlRepository;

    public RemoteControlService(RemoteControlRepository remoteControlRepository) {
        this.remoteControlRepository = remoteControlRepository;
    }

    public List<RemoteControlDto> getAllRemoteControls() {
        List<RemoteControl> remoteControlList = remoteControlRepository.findAll();
        List<RemoteControlDto> remoteControlDtoList = new ArrayList<>();
        for (RemoteControl remoteControl : remoteControlList) {
            RemoteControlDto remoteControlDto = transferRemoteControlToRemoteControlDto(remoteControl);
            remoteControlDtoList.add(remoteControlDto);
        }
        return remoteControlDtoList;
    }


    public RemoteControlDto createRemoteControlDto(RemoteControlInputDto remoteControlInputDto) {
        RemoteControl newRemoteControl = transferRemoteControlInputDtoToRemoteControl(remoteControlInputDto);
        remoteControlRepository.save(newRemoteControl);
        return transferRemoteControlToRemoteControlDto(newRemoteControl);
    }

    public RemoteControlDto getOneRemoteControl(Long id) {
        Optional<RemoteControl> optionalRemoteControl = remoteControlRepository.findById(id);
        if (optionalRemoteControl.isPresent()) {
            RemoteControl remoteControl = optionalRemoteControl.get();
            return transferRemoteControlToRemoteControlDto(remoteControl);
        } else {
            throw new RecordNotFoundException("Item of type Remote Control with id: " + id + " could not be found.");
        }
    }

    public void deleteRemoteControl(Long id) {
        if (remoteControlRepository.existsById(id)) {
            Optional<RemoteControl> toBeDeletedRemoteControl = remoteControlRepository.findById(id);
            RemoteControl remoteControlD = toBeDeletedRemoteControl.get();
            remoteControlRepository.delete(remoteControlD);
        } else {
            throw new RecordNotFoundException("Item of type Remote Control with id: " + id + " could not be found.");
        }
    }

    public RemoteControlDto updateRemoteControl(@PathVariable Long id, RemoteControlInputDto upRemoteControl) {
        Optional<RemoteControl> optionalRemoteControl = remoteControlRepository.findById(id);
        if (optionalRemoteControl.isPresent()) {
            RemoteControl remoteControlOne = optionalRemoteControl.get();

            remoteControlOne.setId(upRemoteControl.getId());
            remoteControlOne.setName(upRemoteControl.getName());
            remoteControlOne.setBrand(upRemoteControl.getBrand());
            remoteControlOne.setCompatibleWith(upRemoteControl.getCompatibleWith());
            remoteControlOne.setBatteryType(upRemoteControl.getBatteryType());
            remoteControlOne.setOriginalStock(upRemoteControl.getOriginalStock());
            remoteControlOne.setPrice(upRemoteControl.getPrice());

            RemoteControl updatedRemoteControl = remoteControlRepository.save(remoteControlOne);
            return transferRemoteControlToRemoteControlDto(updatedRemoteControl);
        } else {
            throw new RecordNotFoundException("Item of type Remote Control with id: " + id + " could not be found.");
        }
    }


    // -------------------------------------------------------------- //

    // HELPER METHODS for conversion REMOTECONTROL:  model - dto - input dto - model //
    public RemoteControlDto transferRemoteControlToRemoteControlDto(RemoteControl remoteControl) {
        RemoteControlDto remoteControlDto = new RemoteControlDto();
        remoteControlDto.setId(remoteControlDto.getId());
        remoteControlDto.setName(remoteControl.getName());
        remoteControlDto.setBrand(remoteControl.getBrand());
        remoteControlDto.setCompatibleWith(remoteControl.getCompatibleWith());
        remoteControlDto.setBatteryType(remoteControl.getBatteryType());
        remoteControlDto.setOriginalStock(remoteControl.getOriginalStock());
        remoteControlDto.setPrice(remoteControl.getPrice());

        return remoteControlDto;
    }

    public RemoteControl transferRemoteControlInputDtoToRemoteControl(RemoteControlInputDto remoteControlInputDto) {
        var remoteControl = new RemoteControl();
        remoteControl.setId(remoteControlInputDto.getId());
        remoteControl.setName(remoteControlInputDto.getName());
        remoteControl.setBrand(remoteControlInputDto.getBrand());
        remoteControl.setCompatibleWith(remoteControlInputDto.getCompatibleWith());
        remoteControl.setBatteryType(remoteControlInputDto.getBatteryType());
        remoteControl.setOriginalStock(remoteControlInputDto.getOriginalStock());
        remoteControl.setPrice(remoteControl.getPrice());

        return remoteControl;
    }
}
