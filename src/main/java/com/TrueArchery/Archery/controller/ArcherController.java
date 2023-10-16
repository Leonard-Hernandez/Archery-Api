package com.TrueArchery.Archery.controller;

import com.TrueArchery.Archery.domain.archer.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/archer")
public class ArcherController {

    @Autowired
    private ArcherRepository archerRepository;

    @PostMapping
    public ResponseEntity<ArcherResponseDTO> recordArcher(@RequestBody @Valid ArcherRecordDTO archerRecordDTO, UriComponentsBuilder componentsBuilder){

        Archer archer = new Archer(archerRecordDTO);
        archerRepository.save(archer);

        URI url = componentsBuilder.path("/archer/{id}").buildAndExpand(archer.getId()).toUri();
        return ResponseEntity.created(url).body(new ArcherResponseDTO(archer));

    }

    @GetMapping
    public ResponseEntity<Page<ArcherResponseDTO>> listArchers( Pageable pageable){

        return ResponseEntity.ok(archerRepository.findByActiveTrue(pageable).map(ArcherResponseDTO::new));

    }

    @GetMapping("/{id}")
    public ResponseEntity<ArcherResponseDTO> getArcherById(@PathVariable Long id){
        Archer archer = archerRepository.getReferenceById(id);
        return ResponseEntity.ok(new ArcherResponseDTO(archer));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<ArcherResponseDTO> editArcher(@RequestBody ArcherEditDTO archerEditDTO){

        Archer archer = archerRepository.getReferenceById(archerEditDTO.id());
        archer.updateArcher(archerEditDTO);

        return ResponseEntity.ok(new ArcherResponseDTO(archer));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity disableArcher(@PathVariable Long id){
        Archer archer = archerRepository.getReferenceById(id);
        archer.disableArcher();
        return ResponseEntity.noContent().build();
    }

}
