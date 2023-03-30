package com.muffin.plus.muffinplus.dto;

import com.muffin.plus.muffinplus.domain.Reservation;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@NoArgsConstructor
@Getter
public class ReservationCreateRequest {
    @NotNull
    private int userId;
    @NotNull
    private int chargingStationId;
    @NotNull
    private LocalDateTime dateStarted;
    @NotNull
    private LocalDateTime dateEnded;

    @Builder()
    public ReservationCreateRequest(int userId, int chargingStationId, LocalDateTime dateStarted, LocalDateTime dateEnded) {
        this.userId = userId;
        this.chargingStationId = chargingStationId;
        this.dateStarted = dateStarted;
        this.dateEnded = dateEnded;
    }
    public Reservation toReservation() {
        return Reservation.builder().userId(userId).chargingStationId(chargingStationId).dateStarted(dateStarted).dateEnded(dateEnded).build();
    }
}
