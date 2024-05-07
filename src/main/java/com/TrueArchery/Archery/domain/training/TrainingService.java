package com.TrueArchery.Archery.domain.training;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TrueArchery.Archery.domain.archer.Archer;
import com.TrueArchery.Archery.domain.archer.ArcherRepository;
import com.TrueArchery.Archery.infra.errors.ArcherNotFoundException;
import com.TrueArchery.Archery.infra.errors.InvalidFinalScoreException;
import com.TrueArchery.Archery.infra.errors.TrainingDataNotFoundException;

@Service
public class TrainingService {

    @Autowired
    private TrainingDataRepository trainingDataRepository;

    @Autowired
    private ArcherRepository archerRepository;

    public TrainingDataRecordDTO recordTrainingData(TrainingDataRecordDTO trainingData) {

        Archer archer = archerRepository.findById(trainingData.id_archer())
        .orElseThrow(() -> new ArcherNotFoundException("archer not found"));

        if ((trainingData.arrowsShots() * 10)<= trainingData.finalScore()) {
            throw new InvalidFinalScoreException("Invalid final score");            
        }        

        TrainingData data = new TrainingData(archer, trainingData.rounds(), trainingData.arrowsShots(), trainingData.distance(), trainingData.target(), trainingData.recordDate(), trainingData.finalScore());
        
        trainingDataRepository.save(data);

        return new TrainingDataRecordDTO(data);

    }

    public List<TrainingDataRecordDTO> getTrainingData(Long id) {

        Archer archer = archerRepository.findById(id)
                .orElseThrow(() -> new ArcherNotFoundException("Archer not found"));

        List<TrainingData> data = trainingDataRepository.findByArcherId(id);
        if (data.isEmpty()) {
            throw new TrainingDataNotFoundException("No training data found for archer with id: " + id);
        }

        return data.stream().map(TrainingDataRecordDTO::new).toList();
        
    }

}
