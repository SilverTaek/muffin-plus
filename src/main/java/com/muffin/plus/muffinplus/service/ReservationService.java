package com.muffin.plus.muffinplus.service;

import com.muffin.plus.muffinplus.dto.ReservationCreateRequest;
import com.muffin.plus.muffinplus.repository.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public void registerReservation(ReservationCreateRequest reservationCreateRequest){
        this.reservationRepository.save(reservationCreateRequest.toReservation());
    }
}
