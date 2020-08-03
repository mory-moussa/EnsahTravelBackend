package com.ensah.reservation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.ensah.reservation.entity.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Long>{

	Employe findByEmail(@Param("email") String email);
}
