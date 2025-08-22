package com.valcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valcare.model.Floors;
import com.valcare.service.FloorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/floor")
public class FloorController {

	@Autowired
	private FloorService floorService;

//------------------------------create--Floor---------------------

	@PostMapping
	public Floors createFloor(@Valid @RequestBody Floors floors) {
		return floorService.saveFloor(floors);
	}

}
