package com.TrueArchery.Archery.domain.training;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TrueArchery.Archery.domain.archer.Archer;
import com.TrueArchery.Archery.domain.archer.ArcherRepository;

@Service
public class TrainingService {

    @Autowired
    private TrainingDataRepository trainingDataRepository;

    @Autowired
    private ArcherRepository archerRepository;

    public TrainingDataRecordDTO recordTrainingData(TrainingDataRecordDTO trainingData) {

        Archer archer;

        if (!archerRepository.findById(trainingData.id_archer()).isPresent()) {
            throw new RuntimeException("Archer not found");            
        }else {
            archer = archerRepository.findById(trainingData.id_archer()).get();
        }

        if ((trainingData.arrowsShots() * 10)<= trainingData.finalScore()) {
            throw new RuntimeException("Final score not reached");            
        }

        

        TrainingData data = new TrainingData(archer, trainingData.rounds(), trainingData.arrowsShots(), trainingData.distance(), trainingData.target(), trainingData.recordDate(), trainingData.finalScore());
        
        trainingDataRepository.save(data);

        return new TrainingDataRecordDTO(data);

    }

    public List<TrainingDataRecordDTO> getTrainingData(Long id) {

        if (archerRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Archer not found");            
        }

        List<TrainingData> data = trainingDataRepository.findByArcherId(id);

        return data.stream().map(TrainingDataRecordDTO::new).toList();
        
    }

}
