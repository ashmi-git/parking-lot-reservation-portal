package com.valcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valcare.model.Slots;
import com.valcare.service.SlotService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/slot")
public class SlotController {

	@Autowired
	private SlotService slotService;

//----------------------create--slot--------------------------

	@PostMapping
	public Slots createSlots(@Valid @RequestBody Slots slot) {
		return slotService.saveSlot(slot);
	}

}
