package com.codegym.service.facility;

import com.codegym.model.facility.ServiceType;

import java.util.List;

public interface IServiceTypeService {
    List<ServiceType> findAll();
}
