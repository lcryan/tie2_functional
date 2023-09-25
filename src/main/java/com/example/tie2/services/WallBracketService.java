package com.example.tie2.services;

import com.example.tie2.dtos.WallBracketDto;
import com.example.tie2.dtos.WallBracketInputDto;
import com.example.tie2.exceptions.RecordNotFoundException;
import com.example.tie2.models.WallBracket;
import com.example.tie2.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WallBracketService {

    private final WallBracketRepository wallBracketRepository;

    public WallBracketService(WallBracketRepository wallBracketRepository) {
        this.wallBracketRepository = wallBracketRepository;
    }

    public List<WallBracketDto> getAllWallBrackets() {
        List<WallBracket> wallBracketList = wallBracketRepository.findAll();
        List<WallBracketDto> wallBracketDtoList = new ArrayList<>();
        for (WallBracket wallBracket : wallBracketList) {
            WallBracketDto wallBracketDto = transferWallBracketToWallBracketDto(wallBracket);
            wallBracketDtoList.add(wallBracketDto);
        }
        return wallBracketDtoList;
    }

    public WallBracketDto createWallBracket(WallBracketInputDto wallBracketInputDto) {
        WallBracket newWallbracket = transferWallBracketInputDtoToWallBracket(wallBracketInputDto);
        wallBracketRepository.save(newWallbracket);

        return transferWallBracketToWallBracketDto(newWallbracket);
    }

    public WallBracketDto getOneWallBracket(Long id) {
        Optional<WallBracket> optionalWallBracket = wallBracketRepository.findById(id);
        if (optionalWallBracket.isPresent()) {
            WallBracket wallbracket = optionalWallBracket.get();
            return transferWallBracketToWallBracketDto(wallbracket);
        } else {
            throw new RecordNotFoundException("Item of type Wall-bracket with id: " + id + " could not be found.");
        }
    }

    public void deleteWallBracket(Long id) {

        if (wallBracketRepository.existsById(id)) {
            Optional<WallBracket> toBeDeletedWallbracket = wallBracketRepository.findById(id);
            WallBracket wallBracketD = toBeDeletedWallbracket.get();
            wallBracketRepository.delete(wallBracketD);
        } else {
            throw new RecordNotFoundException("Item of type Wall-bracket with id: " + id + " could not be found.");
        }
    }


    public WallBracketDto updateWallbracket(@PathVariable Long id, WallBracketInputDto upWallBracket) {
        Optional<WallBracket> optionalWallBracket = wallBracketRepository.findById(id);
        if (optionalWallBracket.isPresent()) {
            WallBracket wallBracketOne = optionalWallBracket.get();

            wallBracketOne.setId(upWallBracket.getId());
            wallBracketOne.setName(upWallBracket.getName());
            wallBracketOne.setSize(upWallBracket.getSize());
            wallBracketOne.setAdjustable(upWallBracket.isAdjustable());
            wallBracketOne.setPrice(upWallBracket.getPrice());

            WallBracket updatedWallbracket = wallBracketRepository.save(wallBracketOne);
            return transferWallBracketToWallBracketDto(updatedWallbracket);
        } else {
            throw new RecordNotFoundException("Item of type Wall-bracket with id: " + id + " could not be found.");
        }
    }


    // --- Helper methods for transfer WALLBRACKET  - input - dto - model //


    public WallBracketDto transferWallBracketToWallBracketDto(WallBracket wallBracket) {

        WallBracketDto wallBracketDto = new WallBracketDto();

        wallBracketDto.setId(wallBracket.getId());
        wallBracketDto.setName(wallBracket.getName());
        wallBracketDto.setSize(wallBracket.getSize());
        wallBracketDto.setAdjustable(wallBracket.isAdjustable());
        wallBracketDto.setPrice(wallBracket.getPrice());
        return wallBracketDto;
    }

    public WallBracket transferWallBracketInputDtoToWallBracket(WallBracketInputDto wallBracketInputDto) {

        var wallBracket = new WallBracket();

        wallBracket.setId(wallBracketInputDto.getId());
        wallBracket.setName(wallBracketInputDto.getName());
        wallBracket.setSize(wallBracket.getSize());
        wallBracket.setAdjustable(wallBracketInputDto.isAdjustable());
        wallBracket.setPrice(wallBracket.getPrice());

        return wallBracket;
    }
}

