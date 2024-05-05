package com.TrueArchery.Archery.domain.training;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TrainingDataRepository extends JpaRepository<TrainingData, Long> {

    List<TrainingData> findByArcherId(Long id);

}
