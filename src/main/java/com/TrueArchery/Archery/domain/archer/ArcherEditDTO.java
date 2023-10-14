package com.TrueArchery.Archery.domain.archer;

import com.TrueArchery.Archery.domain.gender.Gender;

public record ArcherEditDTO(Long id, String name, Gender gender, Category category) {
}
