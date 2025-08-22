package com.valcare.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

@Entity
public class Reservations {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reservationId;

	@NotBlank(message = "Vehicle number required")
	@Pattern(regexp = "^[A-Z]{2}[0-9]{2}[A-Z]{2}[0-9]{4}$", message = "Vehicle number must follow format XX00XX0000 (e.g., KA05MH1234)")
	private String vehicleNumber;

	@NotBlank(message = "Vehicle type required")
	private String vehicleType;

	@NotNull(message = "Start time required")
	private LocalDateTime startTime;

	@NotNull(message = "End time required")
	private LocalDateTime endTime;

	@Positive(message = "Total cost must be positive")
	private Long totalCost;

	@ManyToOne
	@JoinColumn(name = "slot_id", nullable = false)
	private Slots slot;

	public Long getReservationId() {
		return reservationId;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}

	public Slots getSlot() {
		return slot;
	}

	public void setSlot(Slots slot) {
		this.slot = slot;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public Long getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Long totalCost) {
		this.totalCost = totalCost;
	}

}
