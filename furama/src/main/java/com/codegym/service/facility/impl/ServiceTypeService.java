package com.codegym.service.facility.impl;

import com.codegym.model.facility.ServiceType;
import com.codegym.repository.IServiceTypeRepository;
import com.codegym.service.facility.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceTypeService implements IServiceTypeService {
    @Autowired
    private IServiceTypeRepository serviceTypeRepository;
    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }
}
