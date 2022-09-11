package com.codegym.service.facility;

import com.codegym.model.customer.Customer;
import com.codegym.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    Facility findById (Integer id);

    void delete(Integer id);

    List<Facility> findAll();

    List<Facility> findByFacilityName(String facilityName);

    List<Facility> search();

    void save(Facility facility);
}
