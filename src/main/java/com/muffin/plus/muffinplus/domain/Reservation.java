package com.muffin.plus.muffinplus.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Table(name = "reservation")
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int userId;

    private int chargingStationId;

    private LocalDateTime dateStarted;

    private LocalDateTime dateEnded;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
    private LocalDateTime dateDeleted;

    @Builder
    public Reservation(int userId, int chargingStationId, LocalDateTime dateStarted, LocalDateTime dateEnded, LocalDateTime dateCreated, LocalDateTime dateUpdated) {
        this.userId = userId;
        this.chargingStationId = chargingStationId;
        this.dateStarted = dateStarted;
        this.dateEnded = dateEnded;
        this.dateCreated = LocalDateTime.now();
        this.dateUpdated = LocalDateTime.now();
    }
}
