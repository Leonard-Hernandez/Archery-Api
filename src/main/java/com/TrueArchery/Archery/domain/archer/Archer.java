package com.TrueArchery.Archery.domain.archer;

import com.TrueArchery.Archery.domain.gender.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity(name = "Archer")
@Table(name = "Archers")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idDocument")
public class Archer {
    @Id
    @Column(name = "id_document")
    private String idDocument;

    @Column(name = "name")
    private String name;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "active")
    private boolean active;

    public Archer(ArcherRecordDTO archerRecordDTO) {

        this.idDocument = archerRecordDTO.idDocument();
        this.name = archerRecordDTO.name();
        this.birthday = archerRecordDTO.birthday();
        this.gender = archerRecordDTO.gender();
        this.active = true;

    }

    public void deleteArcher(){this.active = false;}

}

