package com.valcare.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.valcare.model.Reservations;
import com.valcare.model.Slots;

@Service
public interface ReservationService {

	public Reservations saveReservation(Slots slot, String vehicleNumber, String vehicleType, 
			LocalDateTime startTime, LocalDateTime endTime);

	public Reservations findReservationById(Long id);

	public List<Slots> getAvailableSlots(LocalDateTime startTime, LocalDateTime endTime);

	public void deleteReservation(Long reservationId);

}
