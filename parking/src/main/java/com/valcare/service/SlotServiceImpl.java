package com.valcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valcare.model.Slots;
import com.valcare.repository.SlotRepository;

@Service
public class SlotServiceImpl implements SlotService {

	@Autowired
	private SlotRepository slotRepository;

	public Slots saveSlot(Slots slots) {

		return slotRepository.save(slots);
	}

}
