package com.ensah.reservation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ensah.reservation.entity.Vol;

@Repository
public interface VolRepository extends JpaRepository<Vol, Long> {
	
	  @Query("select v from Vol v where v.ville_depart = ?1 and v.ville_arrivee = ?2")
	  List<Vol> findVols(String ville_depart, String ville_arrivee);

}
