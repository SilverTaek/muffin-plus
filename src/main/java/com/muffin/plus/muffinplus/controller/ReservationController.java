package com.muffin.plus.muffinplus.controller;

import com.muffin.plus.muffinplus.dto.ReservationCreateRequest;
import com.muffin.plus.muffinplus.service.ReservationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    @PostMapping("/reservation")
    public void registerReservation(@RequestBody ReservationCreateRequest reservationCreateRequest) {
        reservationService.registerReservation(reservationCreateRequest);
    }
}
