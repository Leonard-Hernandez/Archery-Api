package com.TrueArchery.Archery.controller;

import com.TrueArchery.Archery.domain.archer.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/archer")
public class ArcherController {

    @Autowired
    private ArcherRepository archerRepository;

    @PostMapping
    public ResponseEntity<ArcherResponseDTO> recordArcher(@RequestBody @Valid ArcherRecordDTO archerRecordDTO){

        Archer archer = new Archer(archerRecordDTO);
        archerRepository.save(archer);

        return ResponseEntity.ok(new ArcherResponseDTO(archer));

    }

    @GetMapping
    public ResponseEntity<Page<ArcherResponseDTO>> listArchers( Pageable pageable){

        return ResponseEntity.ok(archerRepository.findByActiveTrue(pageable).map(ArcherResponseDTO::new));

    }

    @PutMapping
    @Transactional
    public ResponseEntity<ArcherResponseDTO> editArcher(@RequestBody ArcherEditDTO archerEditDTO){

        Archer archer = archerRepository.getReferenceById(archerEditDTO.id());
        archer.updateArcher(archerEditDTO);

        return ResponseEntity.ok(new ArcherResponseDTO(archer));

    }

}
