package com.muffin.plus.muffinplus.repository;

import com.muffin.plus.muffinplus.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
