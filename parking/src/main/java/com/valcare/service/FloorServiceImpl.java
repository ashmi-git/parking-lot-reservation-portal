package com.valcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valcare.model.Floors;
import com.valcare.repository.FloorRepository;

@Service
public class FloorServiceImpl implements FloorService {

	@Autowired
	private FloorRepository floorRepository;

	public Floors saveFloor(Floors floor) {
		return floorRepository.save(floor);
	}
}
