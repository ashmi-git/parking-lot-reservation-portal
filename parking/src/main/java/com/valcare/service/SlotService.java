package com.valcare.service;

import org.springframework.stereotype.Service;

import com.valcare.model.Slots;

@Service
public interface SlotService {

	public Slots saveSlot(Slots slots);

}
