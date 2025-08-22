package com.valcare.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.valcare.model.Reservations;
import com.valcare.model.Slots;

@Repository
public interface ReservationRepository extends JpaRepository<Reservations, Long> {

	@Query("SELECT CASE WHEN COUNT(r) > 0 THEN TRUE ELSE FALSE "
			+ "END FROM Reservations r WHERE r.slot = :slot "
			+ "AND r.endTime > :startTime "
			+ "AND r.startTime < :endTime")
	
	boolean checkIfOverlapExists(@Param("slot") Slots slot, 
			@Param("startTime") LocalDateTime startTime,
			@Param("endTime") LocalDateTime endTime);

}
