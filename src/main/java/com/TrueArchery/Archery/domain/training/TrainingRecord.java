package com.TrueArchery.Archery.domain.training;

import com.TrueArchery.Archery.domain.archer.Archer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "TrainingRecord")
@Table(name = "Training_records")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class TrainingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_archer")
    private Archer archer;

    @Column(name = "rounds")
    private Integer rounds;

    @Column(name = "arrows_shot")
    private Integer arrowsShots;

    @Column(name = "distance")
    @Enumerated(EnumType.STRING)
    private Distance distance;

    @Column(name = "target")
    @Enumerated(EnumType.STRING)
    private Target target;

    @Column(name = "record_date")
    private LocalDateTime recordDate;

    @Column(name = "final_score")
    private int finalScore;

}
