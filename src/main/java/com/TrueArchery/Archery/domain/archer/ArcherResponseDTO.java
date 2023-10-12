package com.TrueArchery.Archery.domain.archer;

import com.TrueArchery.Archery.domain.gender.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record ArcherResponseDTO(String idDocument, String name) {
    public ArcherResponseDTO(ArcherRecordDTO archerRecordDTO) {

        this(archerRecordDTO.idDocument(), archerRecordDTO.name());

    }
}
