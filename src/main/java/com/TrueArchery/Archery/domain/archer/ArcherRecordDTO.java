package com.TrueArchery.Archery.domain.archer;

import com.TrueArchery.Archery.domain.gender.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ArcherRecordDTO(
        @NotBlank
        String idDocument,
        @NotBlank
        String name,
        @NotNull
        LocalDate birthdate,
        @NotNull
        Category category,
        @NotNull
        Gender gender) {
}
