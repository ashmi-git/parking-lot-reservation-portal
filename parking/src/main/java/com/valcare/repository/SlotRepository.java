package com.valcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valcare.model.Slots;

@Repository
public interface SlotRepository extends JpaRepository<Slots, Long> {

}
