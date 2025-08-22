package com.valcare.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "floors")
public class Floors {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "floor_id")
	private Long floorId;

	@NotBlank(message = "Floor name required")
	private String floorName;

	@NotNull(message = "totalSlot required")
	private Long totalSlots;

	public Long getFloorId() {
		return floorId;
	}

	public void setFloorId(Long floorId) {
		this.floorId = floorId;
	}

	public String getFloorName() {
		return floorName;
	}

	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}

	public Long getTotalSlots() {
		return totalSlots;
	}

	public void setTotalSlots(Long totalSlots) {
		this.totalSlots = totalSlots;
	}

}
