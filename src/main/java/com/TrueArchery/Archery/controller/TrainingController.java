package com.TrueArchery.Archery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.TrueArchery.Archery.domain.training.TrainingDataRecordDTO;
import com.TrueArchery.Archery.domain.training.TrainingService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/training")
public class TrainingController {

    @Autowired
    private TrainingService trainingService;

    @PostMapping
    @Transactional
    public ResponseEntity recordTrainingData(@RequestBody  @Valid TrainingDataRecordDTO trainingDataRecordDTO){
        
        var response = trainingService.recordTrainingData(trainingDataRecordDTO);

        return ResponseEntity.ok(response);
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<TrainingDataRecordDTO>> getTrainingData(@PathVariable Long id){

        var response = trainingService.getTrainingData(id); 
        
        return ResponseEntity.ok(response);
    }
}
