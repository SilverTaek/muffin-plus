package com.muffin.plus.muffinplus.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int status;

    private int chgerType;

    private int zcode;

    private int zscode;

    private LocalDateTime dateCreated;

    private LocalDateTime dateUpdated;

    private LocalDateTime dateDeleted;
}
