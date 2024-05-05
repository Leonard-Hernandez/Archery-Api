package com.TrueArchery.Archery.domain.training;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TrainingDataRecordDTO(
    @NotNull
    Long id_archer,
    @NotNull
    Integer rounds,
    @NotNull
    Integer arrowsShots,
    @NotNull
    Distance distance,
    @NotNull
    Target target,
    LocalDateTime recordDate,
    @NotNull
    Integer finalScore
) {

    public TrainingDataRecordDTO(TrainingData data) {
        this(data.getArcher().getId(), data.getRounds(), data.getArrowsShots(), data.getDistance(), data.getTarget(), data.getRecordDate(), data.getFinalScore());
    }

}
