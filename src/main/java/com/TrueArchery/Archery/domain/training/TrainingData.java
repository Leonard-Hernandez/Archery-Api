package com.TrueArchery.Archery.domain.training;

import com.TrueArchery.Archery.domain.archer.Archer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "TrainingData")
@Table(name = "Training_Data")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class TrainingData {    

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
    private Integer finalScore;

    public TrainingData(Archer archer, Integer rounds, Integer arrowsShots, Distance distance, Target target,
            LocalDateTime recordDate, Integer finalScore) {
        
        this.archer = archer;
        this.rounds = rounds;
        this.arrowsShots = arrowsShots;
        this.distance = distance;
        this.target = target;
        if (recordDate == null) {
            this.recordDate = LocalDateTime.now();
        }else {
            this.recordDate = recordDate;
        }
       
        this.finalScore = finalScore;
    }

    

}
