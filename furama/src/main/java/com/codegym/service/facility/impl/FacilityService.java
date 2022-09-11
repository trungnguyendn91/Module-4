package com.codegym.service.facility.impl;

import com.codegym.model.customer.Customer;
import com.codegym.model.facility.Facility;
import com.codegym.model.facility.RentType;
import com.codegym.model.facility.ServiceType;
import com.codegym.repository.IFacilityRepository;
import com.codegym.repository.IRentTypeRepository;
import com.codegym.repository.IServiceTypeRepository;
import com.codegym.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository facilityRepository;


    @Override
    public Facility findById(Integer id) {
        return facilityRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
       facilityRepository.delete(findById(id));
    }

    @Override
    public List<Facility> findAll() {
        return facilityRepository.findAll();
    }

    @Override
    public List<Facility> findByFacilityName(String facilityName) {
        return facilityRepository.findAllByFacilityNameContaining(facilityName);
    }

    @Override
    public List<Facility> search() {
        return facilityRepository.findAll();
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }

}
