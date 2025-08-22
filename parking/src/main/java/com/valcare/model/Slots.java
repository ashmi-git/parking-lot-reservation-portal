package com.valcare.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Slots {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long slotId;

	@NotNull(message = "slot number required")
	private Long slotNumber;

	@ManyToOne
	@JoinColumn(name = "floor_Id", nullable = false)
	private Floors floor;

	@NotBlank(message = "vehicle type required")
	private String vehicleType;

	public Long getSlotId() {
		return slotId;
	}

	public void setSlotId(Long slotId) {
		this.slotId = slotId;
	}

	public Long getSlotNumber() {
		return slotNumber;
	}

	public void setSlotNumber(Long slotNumber) {
		this.slotNumber = slotNumber;
	}

	public Floors getFloor() {
		return floor;
	}

	public void setFloor(Floors floor) {
		this.floor = floor;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

}
