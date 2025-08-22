package com.valcare.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.valcare.model.Reservations;
import com.valcare.model.Slots;
import com.valcare.repository.SlotRepository;
import com.valcare.service.ReservationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/reserve")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	@Autowired
	private SlotRepository slotRepository;

//------------------------------------------Create--Reservation-------------------------------------------------------

	@PostMapping
	public Reservations reserveSlot(@Valid @RequestBody Reservations reservation) {
		Slots slot = slotRepository.findById(reservation.getSlot().getSlotId())
				.orElseThrow(() -> new RuntimeException("Slot not found"));
		reservation.setSlot(slot);
		return reservationService.saveReservation(slot, reservation.getVehicleNumber(), reservation.getVehicleType(),
				reservation.getStartTime(), reservation.getEndTime());
	}

//----------------------------------------Get--Availability-----------------------------------------------------------

	@GetMapping("/availability")
	public List<Slots> getAvailability(@RequestParam String startTime, 
			@RequestParam String endTime) {

		LocalDateTime start = LocalDateTime.parse(startTime);
		LocalDateTime end = LocalDateTime.parse(endTime);

		return reservationService.getAvailableSlots(start, end);
	}

//---------------------------------------Get--Reservation--Details---------------------------------------------------- 

	@GetMapping("/{id}")
	public Reservations getReservationDetails(@PathVariable long id) {
		return reservationService.findReservationById(id);
	}

//-----------------------------------------Delete--Reservation--------------------------------------------------------	

	@DeleteMapping("/{id}")
	public void deleteReservation(@PathVariable long id) {
		reservationService.deleteReservation(id);
	}

}
