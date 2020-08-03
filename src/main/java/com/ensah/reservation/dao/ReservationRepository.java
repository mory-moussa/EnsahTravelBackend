package com.ensah.reservation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensah.reservation.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

}
