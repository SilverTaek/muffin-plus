package com.muffin.plus.muffinplus.service;

import com.muffin.plus.muffinplus.dto.ReservationCreateRequest;
import com.muffin.plus.muffinplus.repository.ReservationRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Transactional
    public void registerReservation(ReservationCreateRequest reservationCreateRequest){
        // 예약 시간 중복 유효성 검증 코드 추가
        this.reservationRepository.save(reservationCreateRequest.toReservation());
    }
}
