package com.TrueArchery.Archery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TrueArchery.Archery.domain.training.TrainingDataRecordDTO;
import com.TrueArchery.Archery.domain.training.TrainingService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
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

}
