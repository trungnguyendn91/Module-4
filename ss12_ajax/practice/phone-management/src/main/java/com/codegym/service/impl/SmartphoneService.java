package com.codegym.service.impl;

import com.codegym.model.Smartphone;
import com.codegym.repository.ISmartphoneRepository;
import com.codegym.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SmartphoneService implements ISmartphoneService {
    @Autowired
    ISmartphoneRepository smartphoneRepository;
    @Override
    public Page<Smartphone> findAll(Pageable pageable) {
        return this.smartphoneRepository.findAll(pageable);
    }

    @Override
    public Optional findById(Integer id) {
        return smartphoneRepository.findById(id);
    }


    @Override
    public void save(Smartphone smartphone) {
        smartphoneRepository.save(smartphone);
    }

    @Override
    public void remove(Integer id) {
        smartphoneRepository.deleteById(id);
    }


}
