package com.TrueArchery.Archery.controller;

import com.TrueArchery.Archery.domain.archer.Archer;
import com.TrueArchery.Archery.domain.archer.ArcherRecordDTO;
import com.TrueArchery.Archery.domain.archer.ArcherRepository;
import com.TrueArchery.Archery.domain.archer.ArcherResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/archer")
public class ArcherController {

    @Autowired
    private ArcherRepository archerRepository;

    @PostMapping
    public ResponseEntity<ArcherResponseDTO> recordArcher(@RequestBody @Valid ArcherRecordDTO archerRecordDTO){

        Archer archer = new Archer(archerRecordDTO);
        archerRepository.save(archer);

        return ResponseEntity.ok(new ArcherResponseDTO(archerRecordDTO));

    }

}
