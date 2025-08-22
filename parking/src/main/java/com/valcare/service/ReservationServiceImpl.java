package com.valcare.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valcare.model.Reservations;
import com.valcare.model.Slots;
import com.valcare.repository.ReservationRepository;
import com.valcare.repository.SlotRepository;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private SlotRepository slotRepository;

//------------------------------------------create--reservation-----------------------------------------

	public Reservations saveReservation(Slots slot, String vehicleNumber, String vehicleType, LocalDateTime startTime,
			LocalDateTime endTime) {

		if (!startTime.isBefore(endTime)) {
			throw new IllegalArgumentException("Start time must be before end time");
		}

		long durationHours = java.time.Duration.between(startTime, endTime).toHours();
		if (durationHours > 24) {
			throw new IllegalArgumentException("Reservation duration cannot exceed 24 hours");
		}

		boolean isOverlap = reservationRepository.checkIfOverlapExists(slot, startTime, endTime);
		if (isOverlap) {
			throw new RuntimeException("Slot is already booked for the given time range");
		}

		long hours = java.time.Duration.between(startTime, endTime).toHours();
		if (java.time.Duration.between(startTime, endTime).toMinutes() % 60 != 0) {
			hours++;
		}

		java.util.Map<String, Integer> rates = new java.util.HashMap<>();
		rates.put("4W", 30);
		rates.put("2W", 20);

		int rate = rates.getOrDefault(vehicleType.toUpperCase(), 25);
		long totalCost = hours * rate;

		Reservations reservation = new Reservations();
		reservation.setSlot(slot);
		reservation.setVehicleNumber(vehicleNumber);
		reservation.setVehicleType(vehicleType);
		reservation.setStartTime(startTime);
		reservation.setEndTime(endTime);
		reservation.setTotalCost(totalCost);

		return reservationRepository.save(reservation);
	}

//----------------------------------------find--reservation---------------------------------------------

	public Reservations findReservationById(Long reservationId) {
		return reservationRepository.findById(reservationId)
				.orElseThrow(() -> new RuntimeException("Reservation not found"));
	}

//----------------------------------------delete--reservation-------------------------------------------

	public void deleteReservation(Long reservationId) {
		reservationRepository.deleteById(reservationId);
	}

//----------------------------------------get--available--slots-----------------------------------------

	public List<Slots> getAvailableSlots(LocalDateTime startTime, LocalDateTime endTime) {
		List<Slots> allSlots = slotRepository.findAll();
		List<Reservations> reservations = reservationRepository.findAll();
		List<Slots> available = new ArrayList<>();
		for (Slots slot : allSlots) {
			boolean isBooked = false;
			for (Reservations res : reservations) {
				if (res.getSlot().getSlotId().equals(slot.getSlotId())) {
					// Check overlap
					if (res.getEndTime().isAfter(startTime) && res.getStartTime().isBefore(endTime)) {
						isBooked = true;
						break;
					}
				}
			}
			if (!isBooked) {
				available.add(slot);
			}
		}
		return available;
	}

}
