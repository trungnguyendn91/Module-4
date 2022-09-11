package com.codegym.repository;

import com.codegym.model.facility.Facility;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFacilityRepository extends JpaRepository<Facility,Integer> {
    List<Facility> findAllByFacilityNameContaining (String facilityName);
}
