package com.codegym.service.contract.impl;

import com.codegym.model.contract.AttachService;
import com.codegym.repository.IAttachServiceRepository;
import com.codegym.service.contract.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AttachFacilityService implements IAttachFacilityService {
    @Autowired
    IAttachServiceRepository attachServiceRepository;


    @Override
    public List<AttachService> findAllAttachFacility() {
        return attachServiceRepository.findAll();
    }
}
