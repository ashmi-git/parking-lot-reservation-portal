package com.valcare.service;

import org.springframework.stereotype.Service;

import com.valcare.model.Floors;

@Service
public interface FloorService {

	public Floors saveFloor(Floors floor);

}
