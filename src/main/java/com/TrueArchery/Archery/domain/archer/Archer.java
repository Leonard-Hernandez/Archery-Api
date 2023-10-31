package com.TrueArchery.Archery.domain.archer;

import com.TrueArchery.Archery.domain.gender.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Entity(name = "Archer")
@Table(name = "Archers")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Archer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "id_document")
    private String idDocument;

    @Column(name = "archer_name")
    private String name;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "active")
    private boolean active;

    public Archer(ArcherRecordDTO archerRecordDTO) {

        this.idDocument = archerRecordDTO.idDocument();
        this.name = archerRecordDTO.name();
        this.birthday = archerRecordDTO.birthday();
        this.category = archerRecordDTO.category();
        this.gender = archerRecordDTO.gender();
        this.active = true;

    }

    public void updateArcher(ArcherEditDTO archerEditDTO) {

        if(archerEditDTO.name() != null){
            this.name = archerEditDTO.name();
        }

        if(archerEditDTO.gender() != null){
            this.gender = archerEditDTO.gender();
        }

        if(archerEditDTO.category() != null){
            this.category = archerEditDTO.category();
        }

    }

    public void disableArcher() {this.active = false;}

}

